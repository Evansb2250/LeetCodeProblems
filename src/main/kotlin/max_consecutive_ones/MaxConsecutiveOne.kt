package max_consecutive_ones

import java.net.ResponseCache

fun longestOnes(nums: IntArray, k: Int): Int {
//keep track of the highest one count without focusing on 0s
    /***
    1. there is a chance that just tracking the 1's and then using k to add on
    extra 1's may fail becuase there isn't enough connecting 0s.

    2. every time we come across a 0 we check if we can flip it to 1
    we then compare what number we have to the highest flipped number.

     ***/
    var highestBinaryCount = 0
    var flippedOnesRemaining = k
    var currentCount = 0

    var right = 0
    var left = 0

    while (left < nums.size) {
        val bit = nums[left]

        if (bit == 1) {
            currentCount += 1
            left++
        } else if (flippedOnesRemaining > 0) {
            currentCount += 1
            flippedOnesRemaining--
            left++
        } else {
            //What context do I need to move the right
            if (flippedOnesRemaining < 0) {
                if (nums[right] == 0) {
                    flippedOnesRemaining++
                } else {
                    if (currentCount > highestBinaryCount) {
                        highestBinaryCount = currentCount
                        currentCount--
                    }
                    right++
                }
            }
        }
    }

    // only use the number ones


    return highestBinaryCount

}

class MaxConsecutiveOneSolution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var k = k
        var left = 0
        var right: Int
        right = 0
        while (right < nums.size) {

            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left]
                left++
            }
            right++
        }
        return right - left
    }
}

