package k_radius_subarray_averages

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest{
data class Dog(
   var name: String = "ham"
)
    var i = 5

    fun getSquaredI() = (i * i).also {
        i++
    }
    @Test
    fun getAverageTestSample(){
        val test = intArrayOf(7,4,3,9,1,8,5,2,6,2,5,7,4,3,2,7,9)
      //  val result  = Solution().getAverages(test, 3)
      val n = getSquaredI()
       assertEquals(26, n)
    }


}