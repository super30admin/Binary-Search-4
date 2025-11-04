# Time Complexity: O(m+n)
# Space Complexity: O(1) (the result array is considered as auxillary space)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1) > len(nums2): 
            return self.intersect(nums2, nums1)
        res = []
        nums1.sort()
        nums2.sort()

        i,j,n1,n2 = 0,0,len(nums1), len(nums2)

        while i < n1 and j < n2: 
            if nums1[i] == nums2[j]: 
                res.append(nums1[i])
                i+=1
                j+=1
            elif nums1[i] < nums2[j]: 
                i+=1
            else: 
                j+=1

        return res


        
