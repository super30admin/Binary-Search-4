class Solution:
    """
    TC - O(log(m))
    SC - O(1)
    """
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if not nums1 and not nums2:
            return 0.0
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        low, high = 0, n1
        while low <= high:
            partX = low + (high-low) // 2
            partY = ((n1+n2) // 2 ) - partX
            if partX == 0:
                l1 = -9999999
            else:
                l1 = nums1[partX-1]
            if partX == n1:
                l2 = 9999999
            else:
                l2 = nums1[partX]
            if partY == 0:
                r1 = -9999999
            else:
                r1 = nums2[partY-1]
            if partY == n2:
                r2 = 9999999
            else:
                r2 = nums2[partY]
            if l1 <= r2 and r1 <= l2:
                if (n1+n2) % 2 == 0:
                    return (max(l1,r1)+min(l2,r2)) / 2
                else:
                    return min(l2,r2)
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1
        return 0.0