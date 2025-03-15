'''
// Time Complexity : O(m*logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return None
        m, n = len(nums1), len(nums2)
        if m > n:
            return self.intersect(nums2, nums1)
        
        def binarySearch(arr, l, h, target):
            while l <= h:
                
                mid = (l + h) // 2
                if arr[mid] == target:
                    # check if leftmost
                    if mid == l or arr[mid] > arr[mid - 1]:
                        return mid
                    else:
                        h = mid - 1
                elif arr[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1
        
        nums1.sort()
        nums2.sort()
        res = []
        l, h = 0, n - 1
        for i in range(m):
            target = nums1[i]
            bsIdx = binarySearch(nums2, l, h, target)
            if bsIdx != -1:
                res.append(target)
                l = bsIdx + 1
        return res
