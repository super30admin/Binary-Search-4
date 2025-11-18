"""
TC: O(N log N + M log M) {We sort both arrays first (O(N log N) and O(M log M)).  
                           For each element in nums1, we perform a binary search on nums2 
                           within a shrinking window, giving worst-case O(N log M).  
                           Combined, this results in O(N log N + M log M).}
SC: O(1) {Aside from a few pointers and the result list, we use no additional 
           data structures proportional to input size. Sorting is done in place.}

Approach:
We are tasked with computing the intersection of two arrays, including duplicates.  
To do this efficiently, we sort both arrays and then search for each element of nums1 inside nums2.

Key steps:
1. Sort nums1 and nums2 so that duplicates are grouped together.
2. Define a binary search that:
       - Searches nums2 for the first occurrence of the target.
       - Ensures duplicates are handled correctly by locating the earliest index.
3. Iterate over nums1:
       - For each element, binary search nums2 in the current range [low, high].
       - If found, append the element to the result.
       - Update `low` to `bsIdx + 1` to avoid reusing elements and to correctly count duplicates.
4. Return the result list.

This approach leverages sorted order and binary search to efficiently handle duplicates 
and avoid unnecessary scans.

This problem ran successfully on Leetcode.
"""

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def binarySearch(nums, target,l, h):

            while l <= h:
                mid = l + (h-l)//2

                if nums[mid] == target:
                    if mid == l or nums[mid - 1] != nums[mid]:
                        return mid
                    else:
                        h = mid - 1
                elif nums2[mid] > target:
                    h = mid - 1
                else:
                    l = mid + 1

            return -1


        nums1.sort()
        nums2.sort()
        n1, n2 = len(nums1), len(nums2)
        low, high = 0, n2-1
        res = []
        for each in nums1:
            bsIdx = binarySearch(nums2, each, low, high)
            if bsIdx != -1: #we find the element in nums2
                res.append(each)
                low = bsIdx + 1 #we start the search space from prev found element to tackle duplicates
        
        return res