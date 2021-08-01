import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class MainKtTest {

    @Test
    fun nw() {
        val x = "AGGGCT"
        val y = "AGGCA"
        val agap = -2

        nw(x, y, agap, alfa)
    }

    @Test
    fun alfa() {
        assertTrue(alfa('A', 'A') > 0)
        assertTrue(alfa('A', 'B') < 0)
    }
}