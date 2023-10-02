package sortedSquares

fun sortedSquares(nums: IntArray): IntArray {
    var x = 0
    var y = nums.size - 1

    for (i in 0..nums.size - 1) {
        nums[i] = nums[i] * nums[i]
    }

  return  nums.sortedArray()

}





