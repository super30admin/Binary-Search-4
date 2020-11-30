#Time Complexity : O(log(m)) - Smaller array
#Space Complexity : O(1)


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        l, h = 0, n1
        
        while l<=h:
            mid = (l+h)//2
            mid2 = (n1+n2)//2 - mid
            l1 = nums1[mid-1] if mid!=0 else float("-inf")
            r1 = nums1[mid] if mid!=n1 else float("inf")
            l2 = nums2[mid2-1] if mid2!=0 else float("-inf")
            r2 = nums2[mid2] if mid2!=n2 else float("inf")
            

            if l1 <= r2 and l2 <= r1:

                if (n1+n2)%2 == 0:
                    return (max(l1, l2) + min(r1, r2))/2
                else:
                    return min(r1, r2)
            elif l2 > r1:
                l = mid + 1
            else:
                h = mid - 1
            