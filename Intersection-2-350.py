# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#just store the bigger array with frequency in hashmap and reduce the count for every element in smaller array from map
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1) < len(nums2):
            return self.intersect(nums2, nums1)
        
        res = {} 
        for i in nums1:
            if i not in res:
                res[i] = 1
            else:
                res[i] += 1
      
        ans = []
        for j in nums2:
            if j in res and res[j] > 0:
                res[j] -=1
                ans.append(j)
        return ans
