package hash

fun repeatedCharacter(s: String): Char {
    val hashMap = hashMapOf<Char, Int>()
    for(letter in s){
        if(hashMap.containsKey(letter)){
            return letter
        }
        hashMap[letter] = 1
    }
    return 'c'
}