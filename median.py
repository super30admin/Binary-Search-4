# Time Complexity : O log(M+N) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        if(len(nums1) > len(nums2)):
            nums1,nums2 = nums2,nums1
        
        low=0
        high=len(nums1)
        
        while(low<=high):
            partX=low+(high-low)//2
            partY=((len(nums1)+len(nums2))//2) - partX
            print(partX)
            
            l1 = float('-infinity') if (partX==0) else nums1[partX-1]
            l2 = float('-infinity') if (partY==0) else nums2[partY-1]
            r1 = float('infinity') if (partX==len(nums1)) else nums1[partX]
            r2 = float('infinity') if (partY==len(nums2)) else nums2[partY]
            
            if(l2>r1):
                low=partX+1
            elif(l1>r2):
                high=partX-1
            else:
                if(len(nums1)+len(nums2))%2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
        return 323.323
        
        
solution = Solution()
print(f'OUTPUT >> {solution.findMedianSortedArrays([1,2],[3,4])}')