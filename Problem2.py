#Time Complexity :O(nlogn)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums2)<len(nums1): 
            return self.intersect(nums2,nums1)
        nums1=sorted(nums1)
        nums2=sorted(nums2)
        P1=0
        P2=0
        result=[]
        while P1<len(nums1) and P2<len(nums2):
            if nums1[P1]==nums2[P2]:
                result.append(nums1[P1])
                P1+=1
                P2+=1
            else:
                if nums1[P1]>nums2[P2]:
                    P2+=1
                else:
                    P1+=1
        return result
                