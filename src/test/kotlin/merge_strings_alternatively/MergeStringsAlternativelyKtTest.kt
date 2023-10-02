package merge_strings_alternatively

import org.junit.Assert.*
import org.junit.Test

class MergeStringsAlternativelyKtTest {

    @Test
    fun mergeAlternatively_succes() {
        val expectedValue = "apbqrs"

        val word1 = "ab"
        val word2 = "pqrs"
        val result = mergeAlternatively(word1, word2)
        assertEquals(expectedValue, result)
    }

}