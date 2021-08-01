import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class MainKtTest {

    @Test
    fun nw() {
        val x = "AGGGCT"
        val y = "AGGCA"
        val agap = -2

        val p = nw(x, y, agap, alfa)

        val optimalAlignment = optimalAlignment(x, y, agap, alfa, p)

        println(optimalAlignment.first)
        println(optimalAlignment.second)

        assertEquals("AGGGCT", optimalAlignment.first)
        assertEquals("A-GGCA", optimalAlignment.second)
    }

    @Test
    fun alfa() {
        assertTrue(alfa('A', 'A') > 0)
        assertTrue(alfa('A', 'B') < 0)
    }
}