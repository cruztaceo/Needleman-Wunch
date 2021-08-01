fun main() {
    val x = "CGATGCTAGCGTATCGTAGTCTATCGTAC"
    val y = "ACGATGCTAGCGTTTCGTATCATCGTA"
    val agap = -2

    val p = nw(x, y, agap, alfa)

    val optimalAlignment = optimalAlignment(x, y, agap, alfa, p)

    println(optimalAlignment.first)
    println(optimalAlignment.second)
}

fun nw(x: String, y: String, agap: Int, alfa: (x: Char, y: Char) -> Int): Array<IntArray> {
    val m = x.length + 1
    val n = y.length + 1

    val p = Array(m) { IntArray(n) }

    p.forEachIndexed { index, row -> row[0] = index.times(agap) }

    for (j in p[0].indices) {
        p[0][j] = j.times(agap)
    }

    for (i in 1 until m) {
        for (j in 1 until n) {
            val c1 = p[i - 1][j - 1] + alfa(x[i - 1], y[j - 1])
            val c2 = p[i - 1][j] + agap
            val c3 = p[i][j - 1] + agap
            p[i][j] = maxOf(c1, c2, c3)
        }
    }

    p.forEach { println(it.contentToString()) }

    return p
}

val alfa: (Char, Char) -> Int = { x: Char, y: Char ->
    if (x == y) 1
    else -1
}

fun optimalAlignment(
    x: String,
    y: String,
    agap: Int,
    alfa: (x: Char, y: Char) -> Int,
    p: Array<IntArray>
): Pair<String, String> {
    var a1 = ""
    var a2 = ""
    var i = p.size - 1
    var j = p[0].size - 1
    while (i > 0 || j > 0) {
        if (i > 0 && j > 0 && p[i][j] == p[i - 1][j - 1] + alfa(x[i - 1], y[j - 1])) {
            a1 = x[i - 1] + a1
            a2 = y[j - 1] + a2
            i -= 1
            j -= 1
        } else if (i > 0 && p[i][j] == p[i - 1][j] + agap) {
            a1 = x[i - 1] + a1
            a2 = "-$a2"
            i -= 1
        } else {
            a1 = "-$a1"
            a2 = y[j - 1] + a2
            j -= 1
        }
    }
    return Pair(a1, a2)
}