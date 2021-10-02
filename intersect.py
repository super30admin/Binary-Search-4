#Time Complexity : O(n1 log n2) where n1 is length of smaller array
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)==0 or len(nums2) == 0:
            return []
        n1 = len(nums1)
        n2 = len(nums2)
        res = []
        if n1>n2:
            return self.intersect(nums2, nums1)
        nums2.sort()
        for x in nums1:
            l = 0
            h = len(nums2) - 1
            while l<=h:
                m = floor((l+h)/2)
                if nums2[m] == x:
                    res.append(x)
                    del nums2[m]
                    break
                
                elif nums2[m] < x:
                    l = m + 1
                else:
                    h = m -1
        return res
            
        