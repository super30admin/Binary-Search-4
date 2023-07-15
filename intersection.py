# // Time Complexity :O(n*n)
# // Space Complexity :O(k)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans=[]
        for i in nums1:
            if i in nums2:
                ans.append(i)
                nums2.remove(i)
        return ans