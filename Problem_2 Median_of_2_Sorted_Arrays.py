# // Time Complexity : O(min(n1,n2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            #Interchange nums1 and num2 as we want nums1 to be smaller array
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            #partition
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX
            l1 = float(-inf) if partX == 0 else nums1[partX - 1]
            l2 = float(-inf) if partY == 0 else nums2[partY - 1]
            r1 = float(inf) if partX == n1 else nums1[partX]
            r2 = float(inf) if partY == n2 else nums2[partY]

            if l1 <= r2 and l2 <= r1:
                #Correct Partition
                if (n1 + n2) % 2 == 0:
                    #Even
                    return (max([l1, l2]) + min([r1, r2])) / 2
                else:
                    #Odd
                    return min([r1, r2])
            elif l2 > r1:
                #Change low pointer
                low = partX + 1
            else:
                #Change high pointer
                high = partX - 1
        return 1.0