package hash

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Find_Player_With_ZeroKtTest {

    @Test
    fun findWinners() {
        val expected = arrayOf(
            listOf(1, 2, 10),
            listOf(4, 5, 7, 8),
        )
        val testSub = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 6),
            intArrayOf(5, 6),

            intArrayOf(5, 7),
            intArrayOf(4, 5),
            intArrayOf(4, 8),

            intArrayOf(4, 9),
            intArrayOf(10, 4),
            intArrayOf(10, 9),

            )
        val result = findWinners(testSub)

        assertEquals(result, expected.toList())


    }
}