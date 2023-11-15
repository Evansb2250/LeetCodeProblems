package hash

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val intersections = hashMapOf<Int, Boolean>()
    val array = mutableListOf<Int>()
    var i = 0
    for(number in nums1){
        intersections[number] = false
    }
        //TODO an interestection function already exist
    for(number2 in nums2){
        if(intersections.containsKey(number2)){ //TODO add this to list to study
            intersections[number2] = true
        }
    }

    intersections.filter {
        it.value
    }.forEach{
        array.add(it.key)
        i++
    }


    return array.toIntArray()
}