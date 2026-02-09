//
//  IntersectionOfTwoArrays.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/8/26.
//

/*
 approach 1 - hashing based
 time complexity - O(m + n)
 space compelxity - O(min(m,n))
 
 traverse through the smaller arrays and save elements into the hashmap and the corresponding count
 traverse over the bigger array and reduce the count. Wherever encoutering elements in both array, keep it in result.
 
 
 approach 2 - 2 pointers approach -
 traversng both.
 1 pointer on array1
 1 pointer on array2
 check array1 val and array2. whereever smaller one, increment that pointer.
 Bigger array will finish first because all elements would need to be tracked.
 time compelxity - O(m + n)
 
 Approach 3 - Binary search
 we should linearly iterate on the smaller array and do binary search on bigger array.
 Always keep the bigger term logarithmic.
 
 Find the first and last occurrencr of an element
 */
class IntersectionOfTwoArrays {
    
    
    init() {
        
    }
    
    //hash map solution
    func intersectUsingHashMap(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        //traverse throught the smaller array, keep elements in hashmap.
        //traverse through the bigger array and check the elements in the hash map.
        var hashMap = Dictionary<Int, Int>()

        if (nums2.count < nums1.count) {
            intersectUsingHashMap(nums2, nums1)
        }
        for i in 0..<nums1.count {
            if (hashMap[nums1[i]] != nil) {
                hashMap[nums1[i]]! += 1
            } else {
                hashMap[nums1[i]] = 1
            }
        }
        var result = [Int]()
        for i in 0..<nums2.count {
            if (hashMap[nums2[i]] != nil) {
                hashMap[nums2[i]]! -= 1
                result.append(nums2[i])
            }
            if (hashMap[nums2[i]] == 0) {
                hashMap.removeValue(forKey: nums2[i])
            }
        }
        return result
    }

    //Two pointer
    func intersectUsingTwoPointer(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        //2 pointer
        var hashMap = Dictionary<Int, Int>()

        if (nums2.count < nums1.count) {
            intersect(nums2, nums1)
        }

        let sortedN1 = nums1.sorted()
        let sortedN2 = nums2.sorted()

        var p1 = 0
        var p2 = 0
        var result = [Int]()
        while (p1 < sortedN1.count && p2 < sortedN2.count) {
            if (sortedN1[p1] == sortedN2[p2]) {
                result.append(sortedN1[p1])
                p1 += 1
                p2 += 1
            } else if (sortedN1[p1] < sortedN2[p2]) {
                p1 += 1
            } else {
                p2 += 1
            }
        }
        return result
    }
    
    //MARK: Binary search
    func intersectUsingBinarySearch(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        //binary search - n log(n)
        var hashMap = Dictionary<Int, Int>()

        if (nums2.count < nums1.count) {
            intersect(nums2, nums1)
        }

        let sortedN1 = nums1.sorted()
        let sortedN2 = nums2.sorted()
        var low = 0
        var high = sortedN2.count - 1
        var result = [Int]()
        for i in 0..<sortedN1.count {
            let target  = sortedN1[i]

            //find the first index of this target in array2 which is a bigger one
            //bsIdx is the first index of the range of target
            let bsIdx = binarySearch(arr: sortedN2, target: target, low: low, high: high)
            //If I do find the bsIdx, firstly add the target to result and then low = bsidx + 1
            //low will do the binary search from bsIdx + 1 going forward. We are squizzing the range of elements.
            if (bsIdx != -1) {
                result.append(sortedN1[i])
                low = bsIdx + 1
            }
        }

        return result
    }

    func binarySearch(arr: [Int], target: Int, low: Int, high: Int) -> Int {
        var low = low
        var high = high
        while (low <= high) {
            let mid = low + (high - low) / 2
            if (arr[mid] == target) {
                //we found the target, now check if it's the first index of the target
                if (mid == low || arr[mid-1] < arr[mid]) {
                    //we got the first index of the range
                    return mid
                } else {
                    high = mid - 1
                }
            } else if (arr[mid] > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }


}
