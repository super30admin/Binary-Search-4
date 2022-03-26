# Time Complexity : O(m+n )
 # Space Complexity : O(1)
 # Did this code successfully run on leetcode : Yes
 # Any problem you faced while coding this : No
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if (n1 >n2): self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        p1=0
        p2=0
        result =[]
        while p1<n1 and p2<n2:
            if(nums1[p1]==nums2[p2]):
                result.append(nums1[p1])
                p1+=1
                p2+=1
                
            elif(nums1[p1]>nums2[p2]):
                p2+=1
            else:
                p1+=1
            
        return result