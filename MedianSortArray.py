#4. Median of Two Sorted Arrays
"""
Time Complexity : O(n logn)
Space Complexity : O(1)
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) < len(nums2):
            print("here")
            nums1, nums2 = nums2, nums1
        
        n = len(nums1)
        m = len(nums2)
        l = 0
        h = n #not n-1 because we are chekcing intersections NOT elements
        
        while(l <= h):
            x = l + (h - l) // 2
            y = ((m + n)// 2) - x
            
            #for l1
            if x == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[x - 1] #-1 because we ae checking left element x partition
            
            #for l2
            if y == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[y - 1]
                
            #for r1
            if x == n:
                r1 = float('inf')
            else:
                r1 = nums1[x] #no -1 because we are checking right side of partition
                
            #for r2
            if y == m:
                r2 = float('inf')
            else:
                r2 = nums2[y]
                
            #ending condition
            if (l1<=r2 and l2<=r2):
                if (n + m) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            
            #moving forward
            elif l2 > r1:
                l = x + 1
            else:
                h = y -1
