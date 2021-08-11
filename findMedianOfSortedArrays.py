# Time Complexity : O(logn)
# Space Complexity : O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n2 < n1:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1

        while low <= high:
            px = (low + high)//2

            py = (n1 + n2)//2 - px

            l1 = 0
            if px == 0:
                l1 = -9999999999999999999
            else:
                l1 = nums1[px-1]

            l2 = 0
            if py == 0:
                l2 = -9999999999999999999
            else:
                l2 = nums2[py-1]

            r1 = 0
            if px == n1:
                r1 = 9999999999999999999
            else:
                r1 = nums1[px]

            r2 = 0
            if py == n2:
                r2 = 9999999999999999999
            else:
                r2 = nums2[py]

            if l1 <= r2 and l2 <= r1:
                if (n1+n2)%2 == 0:
                    print(l1,l2,r1,r2)
                    return (float(max(l1,l2)+min(r1,r2)))/2
                else:
                    return min(r1,r2)

            elif l2 > r1:
                low = px+1
            else:
                high = px-1
        return 1.00