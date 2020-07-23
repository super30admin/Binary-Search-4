# Time Complexity : Add - O(mlogm + n logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Sorting both arrays and then using 2 pointers
2. If value is same add it to reult and move both pointer
3. If value not same move away from low value
4. When either pointer overflows, stop!
'''


from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1) < 1 or len(nums2)<1:
            return
        
        nums1.sort()
        nums2.sort()
        
        i, j = 0, 0
        
        result = []
        while i<len(nums1) and j < len(nums2):
            
            if nums1[i] == nums2[j]:
                result.append(nums1[i])
                i += 1
                j += 1
            
            elif nums1[i] < nums2[j]:
                i += 1
                
            else:
                j += 1
        
        return result
                
# Hashmap solution   
# Time Complexity : Add - O(m)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. put all values of any array(amaller or bigger) with thier frequencies in hashmap
2. Iterate thry the other array while checking the frequeency if it is > 0
3. If freq is > 0, add the value to result and decrease frequency
'''

from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1) < 1 or len(nums2)<1:
            return
        
        if len(nums1) <= len(nums2):
            smaller = nums1
            bigger = nums2
        else:
            smaller = nums2
            bigger = nums1
           
        hash_ = defaultdict(lambda : 0)
        for i in smaller:
            hash_[i] += 1
            
        result = []
        for i in bigger:
            if i in hash_ and hash_[i] > 0:
                result.append(i)
                hash_[i] -= 1
                
        return result
                