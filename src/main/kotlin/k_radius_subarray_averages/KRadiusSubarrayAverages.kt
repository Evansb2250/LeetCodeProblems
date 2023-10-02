package k_radius_subarray_averages

import java.util.*


// Sliding window approach
internal class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        // When a single element is considered then its average will be the number itself only.
        if (k == 0) {
            return nums
        }
        val n = nums.size
        val averages = IntArray(n)
        Arrays.fill(averages, -1)

        // Any index will not have 'k' elements in its left and right.
        if (2 * k + 1 > n) {
            return averages
        }

        // First get the sum of first window of the 'nums' array.
        var windowSum: Long = 0
        for (i in 0 until 2 * k + 1) {
            windowSum += nums[i].toLong()
        }
        averages[k] = (windowSum / (2 * k + 1)).toInt()

        // Iterate on rest indices which have at least 'k' elements
        // on its left and right sides.
        for (i in 2 * k + 1 until n) {
            // We remove the discarded element and add the new element to get current window sum.
            // 'i' is the index of new inserted element, and
            // 'i - (window size)' is the index of the last removed element.
            windowSum = windowSum - nums[i - (2 * k + 1)] + nums[i]
            averages[i - k] = (windowSum / (2 * k + 1)).toInt()
        }
        return averages
    }
}