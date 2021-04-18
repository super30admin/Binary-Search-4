class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        x = {}
        for i in nums1:
            if(i in x.keys()):
                x[i] +=1
            else:
                x[i] = 1
        
        o = []
        
        for j in nums2:
            if(j in x.keys() and x[j]>0):
                o.append(j)
                x[j] -= 1
        
        return o
