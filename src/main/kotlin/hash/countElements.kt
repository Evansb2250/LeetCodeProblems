package hash

fun countElements(arr: IntArray): Int {
    var count = 0
    val hashMap = hashMapOf<Int, Int>()
    val hashSet = arr.toHashSet()
    val j: HashMap<Int, Int>

    for (x in hashSet){
        if( hashSet.contains(x+1)){
            count ++
        }
    }

    return count
}