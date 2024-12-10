# TC: O(log(min(m, n)))
# SC: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n = len(nums1)
        m = len(nums2)
        if m < n:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n

        while low <= high:
            partX = (low+high) // 2
            partY = ((n+m) // 2) - partX

            l1 = float("-inf")
            l2 = float("-inf")
            r1 = float("inf")
            r2 = float("inf")

            if partX > 0:
                l1 = nums1[partX-1]
            
            if partX < n:
                r1 = nums1[partX]
            
            if partY > 0:
                l2 = nums2[partY-1]
            
            if partY < m:
                r2 = nums2[partY]
            
            if l2 <= r1 and l1 <= r2:
                if (n+m) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2

                else:
                    return min(r1, r2)
            
            elif l2 > r1:
                low = partX + 1
            
            else:
                high = partX - 1
        return -1
