# Runs on Leetcode

    # Solution 1
        # Runtime - O((m+n)log(m+n)) wher m and n are lengths of arrays
        # Memory - O(1)
      
    # Solution 2
        # Runtime - O(logn) where n is length of smallest array
        # Memory - O(1)

# Solution 1

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]):
        nums1 = nums1 + nums2
        nums1.sort()
        mid = len(nums1)//2
        if len(nums1) % 2 == 0:
            return (nums1[mid-1]+nums1[mid])/2
        else:
            return nums1[mid]
            
# Solution 2

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n2 < n1:
            return self.findMedianSortedArrays(nums2,nums1)
        low = 0
        high = n1
        while low <= high:
            partition_n1 = (low + high +1)//2
            partition_n2 = ((n1+ n2+ 1)//2) - partition_n1
            
            l1 = float('-inf') if partition_n1 == 0 else nums1[partition_n1 - 1]
            r1 = float('inf') if partition_n1 == n1 else nums1[partition_n1]
            
            l2 = float('-inf') if partition_n2 == 0 else nums2[partition_n2 - 1]
            r2 = float('inf') if partition_n2 == n2 else nums2[partition_n2]
            
            if l1 <= r2 and l2 <= r1:
                if (n1+n2) % 2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return max(l1,l2)
            elif l2 > r1:
                low = partition_n1 + 1
            else:
                high = partition_n1 - 1
        return -1
