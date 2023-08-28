class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        n1=len(nums1)
        n2=len(nums2)
        if(n2>n1):
            return self.intersect(nums2, nums1)
        h1={}
        h2={}
        result=[]
        for i in nums1:
            h1[i]=h1.get(i,0)+1
        for i in nums2:
            h2[i]=h2.get(i,0)+1
        for i in h2.keys():
            if(i in h1.keys()):
                mul=h1[i] if h1[i]<h2[i] else h2[i]
                result=result+[i]*mul
        return result
        