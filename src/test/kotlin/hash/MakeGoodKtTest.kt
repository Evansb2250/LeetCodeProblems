package hash

import org.junit.Assert.*
import org.junit.jupiter.api.Test

class MakeGoodKtTest{

    @Test
    fun simpleTest(){
        val result =   makeGood("LeEeetCode")
        assertEquals("LeetCode", result)
    }
}