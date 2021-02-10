# Time Complexity : O(m + 2n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Put one array in hashmap {element : frequency}
        iterate other array and check if it's there
                - add element to res
                - decrement frequency 
        """
        hm = defaultdict()
        res = []
        if len(nums2) < len(nums1):
            return self.intersect(nums2,nums1)
        #put nums1 in hm when ideally we want the smaller array to save space
        for i in nums1:
            if i not in hm:
                hm[i] = 1
            else:
                hm[i] += 1
                
        for i in range(len(nums2)):
            if nums2[i] in hm:
                if hm[nums2[i]]:
                    res.append(nums2[i])
                    hm[nums2[i]] -= 1
                    if hm[nums2[i]] == 0:
                        del hm[nums2[i]]
        
        return res