# Time Complexity : O(log m) where m is length of smaller array
# Space Complexity :O(1)

# Approach:
# Consider partitions in the smaller array and make splits such the split makes the secon array also split.
# Now in the formed partition check the boundary values in both the splits and mover the pointers

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partx = low+(high-low)//2
            party = (n1+n2)//2-partx
            if partx == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[partx-1]
            if partx == n1:
                r1 = float('inf')
            else:
                r1 = nums1[partx]
            if party == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[party-1]
            if party == n2:
                r2 = float('inf')
            else:
                r2 = nums2[party]
            if l1 <= r2 and l2 <= r1:
                # odd case
                if (n1+n2) % 2 != 0:
                    return min(r1, r2)
                else:
                    return (max(l1, l2)+min(r1, r2))/2
            elif l2 > r1:
                low = partx+1
            else:
                high = partx-1