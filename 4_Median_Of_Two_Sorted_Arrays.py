# Leetcode problem link : https://leetcode.com/problems/median-of-two-sorted-arrays/
# Time Complexity:    O(m+nlogm) for binary search on smaller array of size m
# Space Complexity:   O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Perform binary search on smaller array (else flip to have nums1 as smaller always)
        Partition smaller array at mid
        Partition the bigger array such that number of elements on left side of parition of both arrays is same as right side ( or left is bigger by 1 max)
        Now when we have equal numbers we check the elements in between to see if they form a median ( by checkng if they are all in increasing sequence) If both left sides are smaller than both right sides then median lies at this point. Calculate based on even/odd and return
        Else, change the partitionX for nums1: if left side of nums2 is greater than rght side of nums1 then partiotn should move towards higher side of nums1 else vice versa.
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        
        n1 = len(nums1)
        n2 = len(nums2)
        low = 0
        high = n1
        
        while low <= high:
            
            mid = low + (high - low)//2
            partitionX = mid
            partitionY = (n1+n2+1)//2 - partitionX
            
            l1 = float('-inf') if partitionX == 0 else nums1[partitionX - 1]
            r1 = float('inf') if partitionX == n1 else nums1[partitionX]
        
            l2 = float('-inf') if partitionY == 0 else nums2[partitionY - 1]
            r2 = float('inf') if partitionY == n2 else nums2[partitionY]
            
            if l1 <= r2 and l2 <= r1:
                if(n1 + n2) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                else:
                    return max(l1,l2)
            elif l2 > r1:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1