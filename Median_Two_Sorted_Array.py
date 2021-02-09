Time Complexity : O(log m) where m is length of smaller array
Space Complexity :O(1)


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partX = (high + low) //2
            partY = (n1+n2)//2-partX
            if partX == 0:
                l1 = float('-inf')
            else:
                l1 = nums1[partX-1]
            if partX == n1:
                r1 = float('inf')
            else:
                r1 = nums1[partX]
            if partY == 0:
                l2 = float('-inf')
            else:
                l2 = nums2[partY-1]
            if partY == n2:
                r2 = float('inf')
            else:
                r2 = nums2[partY]
            if l1 <= r2 and l2 <= r1:
                # odd case
                if (n1+n2) % 2 != 0:
                    return min(r1, r2)
                else:
                    return (max(l1, l2)+min(r1, r2))/2
            elif l2 > r1:
                low = partX+1
            else:
                high = partX-1
