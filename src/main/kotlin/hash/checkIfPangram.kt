package hash

fun checkIfPangram(sentence: String): Boolean {
    val hashSet = hashSetOf<Char>()
    for (letter in sentence){
        hashSet.add(letter)
    }
    return hashSet.size == 26
}