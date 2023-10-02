package subArray

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SolutionTest {
    @Test
    fun  `findMaxAverage solution test`(){
        val result = Solution().findMaxAverage(
            intArrayOf(1,12,-5,-6,50,3, -30, 25),
            4
        )

        assertEquals(12.7500, result)
    }
}