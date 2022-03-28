# // Time Complexity : O(nlog n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def intersect(self, nums1, nums2):
        i, j = 0, 0
        res = []
        # Follow up the lists are sorted
        nums1, nums2 = sorted(nums1), sorted(nums2)
        
        # Two Pointer approach
        while i<len(nums1) and j<len(nums2):
            if nums1[i]<nums2[j]: 
                i+=1
            elif nums2[j]<nums1[i]:
                j+=1
            else:
                res.append(nums1[i])
                j+=1
                i+=1
        return res