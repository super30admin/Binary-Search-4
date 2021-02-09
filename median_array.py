# Time Complexity : O(n log m) where n is the length of longer smaller array and m is the length of smaller array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use partitions and find the correct partition using binary search. Once correct partition is found, return middle element or average of 2 middle elements if 
# total element are even

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        if m > n: return self.findMedianSortedArrays(nums2, nums1)
        left = 0
        right = len(nums1)
        while left <= right:
            mid = left + (right - left) // 2
            p1 = mid
            p2 = (m+n)//2 - p1
            
            l1 = nums1[p1-1] if p1 > 0 else -math.inf
            l2 = nums2[p2-1] if p2 > 0 else -math.inf
            r1 = nums1[p1] if p1 < len(nums1) else math.inf
            r2 = nums2[p2] if p2 < len(nums2) else math.inf

            if l1 <= r2 and l2 <= r1:
                if (m + n) % 2 == 0:
                    return (max(l1,l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)   
            elif l2 > r1:
                left = mid+1
            else:
                right = mid-1
            
        return -1