package array_string

/***
 *  1. Merge Sorted Array.
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    //How do I store something in an immutable Array?
    var subsetTwoIndex = 0
    //I need to have a minus to prevent a index out of bounds error.
    for (i in m..nums1.size - 1) {
        nums1.set(i, nums2.get(subsetTwoIndex))
        subsetTwoIndex++
    }
    nums1.sort()
}
