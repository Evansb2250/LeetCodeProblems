package hash

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val magazineHashMap = hashMapOf<Char, Int>()
    val ransomNoteHashMap = hashMapOf<Char, Int>()

    for (i in 0 until magazine.length) {
        val character = magazine[i]
        magazineHashMap[character] = magazineHashMap[character]?.plus(1) ?: 1
    }

    for (x in 0 until ransomNote.length) {
        val character = ransomNote[x]
        ransomNoteHashMap[character] = ransomNoteHashMap[character]?.plus(1) ?: 1
    }

    for (magazineKey in magazineHashMap.keys) {
        magazineHashMap[magazineKey]?.let { magazineK: Int ->
            ransomNoteHashMap[magazineKey]?.let { ran ->
                if (magazineK >= ran) {
                    ransomNoteHashMap.remove(
                        magazineKey
                    )
                }
            }
        }
    }

    return ransomNoteHashMap.isEmpty()
}


