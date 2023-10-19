# Time Complexity: O(m+n)
# Space Complexity: O(min(m,n))

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        m = len(nums1)
        n = len(nums2)

        if m>n:
            self.intersect(nums2,nums1)
        
        res = []

        dict={}

        for i in nums1:
            if i not in dict:
                dict[i] = 1
            else:
                dict[i]+=1
        
        for i in nums2:
            if i in dict and dict[i]>0:
                res.append(i)
                dict[i]-=1
        return res
            
