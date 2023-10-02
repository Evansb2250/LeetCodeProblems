package merge_strings_alternatively

fun mergeAlternatively(word1: String, word2: String): String {
    val lengthOne = word1.length
    val lengthTwo = word2.length
    var indexOne = 0
    var indexTwo = 0
    var mergeStringOne = true
    var appendingString = ""
    var mergedString = ""


    val intervealUntil = if (lengthOne == lengthTwo) {
        lengthOne
    } else if (lengthOne > lengthTwo) {
        //Abdcdr
        //abb

        appendingString = word1.substring(lengthTwo, lengthOne)
        lengthTwo
    } else {
        appendingString = word2.substring(lengthOne, lengthTwo)
        lengthOne
    }
    while (indexTwo != intervealUntil) {
        if (mergeStringOne) {
            mergedString += word1.get(indexOne)
            indexOne++
            mergeStringOne = false
        } else {
            mergedString += word2.get(indexTwo)
            indexTwo++
            mergeStringOne = true
        }
    }
//    if(indexOne > indexTwo){
//        mergedString += word2.get(indexTwo)
//    }
    return (mergedString + appendingString).trim()
}