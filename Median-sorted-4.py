
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):

        #1) initialize sizes n1 and n2
        #2) check which array is smaller
        #3) do binary search on smaller array
        #4) calculate parititions
        #5) check l1 <= r2 && l2 <= r1 then voila
        #5.1) check if odd or even and return accordingly
        #6) check which side ot move on
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        n1,n2 = len(nums1), len(nums2)
        low = 0
        high = n1
    
        while low <= high:
            mid = low + (high - low) // 2
            partitionX = mid
            partitionY = (n1 + n2 + 1) / 2 - partitionX
            
            L1 = -float('inf') if partitionX == 0 else nums1[partitionX - 1]
            R1 = float('inf') if partitionX == n1 else nums1[partitionX]
            
            L2 = -float('inf') if partitionY == 0 else nums2[partitionY - 1]
            R2 = float('inf') if partitionY == n2 else nums2[partitionY]
            
            if L1 <= R2 and L2 <= R1:
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) +  min(R1, R2)) / 2.0
                else:
                    return max(L1, L2)
            
            if L2 > R1:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1
            