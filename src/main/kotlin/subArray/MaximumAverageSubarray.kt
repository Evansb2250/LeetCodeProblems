package subArray


fun findMaxAverage(nums: IntArray, k: Int): Double {
    var highestAverage: Double = 0.0
    var end = k
    if (nums.size > 1)
        for (i in 0..nums.size - k) {

            if (k <= nums.size) {
                var total: Double = 0.0
                for (y in i..end - 1) {

                    total += nums[y]
                }
                if (total / k > highestAverage || i == 0) {
                    highestAverage = total / k
                }
                end++
            }
        }
    else
        return nums[0].toDouble()

    return highestAverage
}


fun findMaxAverageImproved(nums: IntArray, k: Int): Double {
    var r = 0
    var l = 0
    var highestAverage: Double = 0.0
    var acc = 0.0
    while (l < nums.size) {
        acc += nums[l]
        if (l - r + 1 == k) {
            if (acc / k > highestAverage || r == 0)
                highestAverage = acc / k

            acc -= nums[r]
            r++
        }
        l++
    }


    return highestAverage
}


class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val sum = IntArray(nums.size)
        sum[0] = nums[0]
        for (i in 1 until nums.size)
            sum[i] = sum[i - 1] + nums[i]
        var res = sum[k - 1] * 1.0 / k
        for (i in k until nums.size) {
            println("res = ${res} ${sum[i]} - ${sum[i - k]}")
            res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k)
        }
        return res
    }
}