# Time Complexity : O(log m )
 # Space Complexity : O(1)
 # Did this code successfully run on leetcode : Yes
 # Any problem you faced while coding this : No
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if (len(nums1) == 0 and len(nums2)==0 ) : return 0
        n1 = len(nums1) 
        n2 = len(nums2)
        if(n1> n2): self.findMedianSortedArrays(nums2,nums1)
        low =0
        high =n1
        while (low<=high):
            parx = int(low + (high-low)/2)
            pary = int((n1+n2)/2 -parx)
            # print( parx,pary)
            l1 = float('-inf') if parx==0  else nums1[parx-1] 
            r1 = float('inf') if parx==n1 else nums1[parx]
            l2 = float('-inf') if pary == 0  else nums2[pary-1] 
            r2 = float('inf') if pary==n2 else nums2[pary]
            
            # base
            if (l1<=r2 and l2<=r1):
                if(n1+n2)%2 == 1: 
                    return min(r2,r1)   
                else:
                    return (max(l1,l2)+min(r2,r1))/2
            elif(l1>r2):
                high = parx -1
            else:
                low = parx+1
        # return 1
     
                
                
                
        