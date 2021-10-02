#Time Complexity : O(log n1) where n1 is length of smaller array
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0 and len(nums2) == 0:
            return 0.0
        n1 = len(nums1)
        n2 = len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2, nums1)
        l = 0
        h = n1
        while l<=h:
            x = floor((l+h)/2)
            y = floor((n1+n2)/2) -x
            if x == 0:
                l1 = -math.inf
            else:
                l1 = nums1[x-1]
            if x == n1:
                r1 = math.inf
            else:
                r1 = nums1[x]
            if y == 0:
                l2 = -math.inf
            else:
                l2 = nums2[y-1]
            if y == n2:
                r2 = math.inf
            else:
                r2 = nums2[y]
            
            if l1<=r2 and l2<= r1:
                #correct
                if (n1+n2)%2 == 0:
                    return (max(l1, l2) + min(r1, r2))/2
                else:
                    return min(r1, r2)
            elif l1 > r2:
                h = x-1
            else:
                l = x+1