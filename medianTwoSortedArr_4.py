# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Your approach:

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        #check which array is smaller
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        
        #initialise sizes
        n1 = len(nums1)
        n2 = len(nums2)
        
        #do binary search on smller array
        low = 0
        high = n1
        
        while low<=high:
            mid = low + (high-low)//2
            
            #calculate partition
            partX = mid
            partY = (n1+n2+1)//2 - partX
            
            l1 = -float('inf') if partX == 0 else nums1[partX-1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            l2 = -float('inf') if partY == 0 else nums2[partY-1]
            r2 = float('inf') if partY == n2 else nums2[partY]
            
            # check if l1<=r2 and l2<=r1 then voila
            if l1<=r2 and l2<=r1:
                # check if it is odd or even and return acc.
                if (n1+n2)%2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return max(l1,l2)
            # check which side to move on
            elif l2>r1:
                low = mid+1
            else:
                high = mid-1
                
        return -1
                
        
        
        
        
        