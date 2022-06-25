class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        if len(nums1)>len(nums2):
            return self.helper(nums1,nums2)
        else:
            return self.helper(nums2,nums1)
        
    def helper(self,nums1,nums2):
        output=[]
        i=0
        j=0
        while i<len(nums1) and j<len(nums2):
            if nums1[i]==nums2[j]:
                output.append(nums1[i])
                i+=1
                j+=1
            elif nums1[i]>nums2[j]:
                j+=1
            else:
                i+=1
        return output
                
            