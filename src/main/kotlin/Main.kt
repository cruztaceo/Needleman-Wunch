fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
}

fun nw(x: String, y: String, agap: Int, alfa: (x: Char, y: Char) -> Int): Int {
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

    return p[m - 1][n - 1]
}

val alfa: (Char, Char) -> Int = { x: Char, y: Char ->
    if (x == y) 1
    else -1
}