'''
Time Complexity --> O(m+n)
Space Complexity --> O(n) if we input all the elemnts in haspmap of 2nd list array
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map = {}
        res = []
        for i in nums2:
            try:
                map[i]+=1
            except:
                map[i]=1
        for j in nums1:
            if j in map:
                map[j]-=1
                if map[j]==0:
                    del(map[j])
                res.append(j)
        return(res)    