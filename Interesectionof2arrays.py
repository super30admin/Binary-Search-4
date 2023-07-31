# Time Complexity : O(n1+n2).
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use sorted arrays and two pointers to iterate and find the intersection.
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.intersect(nums2, nums1)
        p1,p2=0,0
        li=[]
        nums1=sorted(nums1)
        nums2=sorted(nums2)
        while(p1<n1 and p2<n2):
            if(nums1[p1]==nums2[p2]):
                li.append(nums1[p1])
                p1+=1
                p2+=1
            elif(nums1[p1]>nums2[p2]):
                p2+=1
            else:
                p1+=1
        return li
