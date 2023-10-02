package max_consecutive_ones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxConsecutiveOneKtTest {

    @Test
    fun longestOnesSolutionCode() {
        val array = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
        val result = MaxConsecutiveOneSolution().longestOnes(
            array,
            3
        )


        val expected = 10

        assertEquals(expected, result)
    }


    @Test
    fun prefixSumExampleTest() {
        //      val result = prefixSumExample(intArrayOf(3,6,2,8,1,4,1,5))
        //    assertArrayEquals(intArrayOf(3,9,11,19,20,24,25,30), result)

    }
}