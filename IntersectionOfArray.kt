// In this problem, we perform sorting and binary search to find the intersection of two arrays. We sort both arrays and then for each element in the smaller array, we perform a binary search in the larger array to find 
// the element. If we find the element, we add it to the result liste and update the low pointer to the index after the found elemente to avoid counting duplicates. 
// Time Complexity: O(n log n + m log m + n log m) where n and m are the sizes of the two input arrays.
// Space Complexity : O(1) as we don't consider the output array. 

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val n1 = nums1.size
        val n2 = nums2.size 

        if(n1 > n2) {
            return intersect(nums2, nums1)
        }

        val result = mutableListOf<Int>()
        Arrays.sort(nums1)
        Arrays.sort(nums2) 

        var low = 0 
        val high = n2 - 1

        for(num in nums1) {
            val bsIndx = binarySearch(nums2, num, low, high)
            if(bsIndx != -1) {
                result.add(num)
                low = bsIndx + 1
            }
        }

        val resultArr = IntArray(result.size)
        for(i in 0 until result.size) {
            resultArr[i] = result.get(i)
        }

        return resultArr

    }

    fun binarySearch(nums: IntArray, target: Int, newlow: Int, newhigh : Int) : Int {
        var low = newlow
        var high = newhigh
        while(low <= high) {
            val mid = low + (high - low)/2
            if(nums[mid]== target) {
                if(mid == low || nums[mid - 1] != nums[mid]) {
                    return mid
                } else {
                    high = mid - 1
                }
            } else if(nums[mid] > target) high = mid - 1
            else low = mid + 1

        }
        return -1
    }
}