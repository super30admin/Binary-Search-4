//
//  MedianOfTwoSortedArray.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/8/26.
//

/*
 array 1
 array2
 add array2 in array1
 then sort the array. (m+n)log(m+n)
 
 approach 2 - two pointer - O(m + n) > maximum between m and n
 
 approach 3 ->
 imagine these arrays with partitions.
 time complexity -> log(n1)
 */

class MedianOfTwoSortedArray {
    func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
        let n1 = nums1.count
        let n2 = nums2.count
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1)
        }

        var low = 0
        var high = n1
        while (low <= high) {
            let partX = low + (high - low)/2 //mid
            let partY = (n1 + n2)/2 - partX

            let l1: Double = partX == 0 ? Double(Int.min) :Double(nums1[partX - 1])
            let r1: Double = partX == n1 ? Double(Int.max) : Double(nums1[partX])
            let l2: Double = partY == 0 ? Double(Int.min) : Double(nums2[partY - 1])
            let r2: Double = partY == n2 ? Double(Int.max) : Double(nums2[partY])

            if (l1 <= r2 && l2 <= r1) {
                //find median
                if ((n1 + n2) % 2 == 0) {
                    //even
                    return (max(l1, l2) + min(r1, r2)) / 2.0
                } else {
                    return min(r1, r2)
                }
            } else if (l1 > r2) {
                high = partX - 1
            } else if (l2  > r1) {
                low = partX + 1
            }
        }
        return -1.0
    }
}
