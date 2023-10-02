package subArray

import org.junit.Assert.assertEquals
import org.junit.Test

@Suppress("DEPRECATION")
internal class MaximumAverageSubarrayKtTest{

    @Test
    fun `fin max Average`(){
        val array = intArrayOf(-2,-4,-5,-9)
        val k = 4
        val delta = 0.0001 // Set an appropriate delta value

        val result = findMaxAverageImproved(array,k)
        assertEquals(-5.0, result, delta)
    }
}