class Solution:
    #Time Complexity : O(m+n)
    #Space Complexity : O(1)

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        size = len(nums1) + len(nums2)
        average = False
        if size % 2 == 0:
            average = True
        l, r = 0, len(nums1) - 1
        while True:
            mid = (l + r) // 2
            partition = (size // 2) - mid - 2

            nums1Left = nums1[mid] if mid >= 0 else float("-inf")
            nums1Right = nums1[mid + 1] if (mid + 1) < len(nums1) else float("inf")
            nums2Left = nums2[partition] if partition >= 0 else float("-inf")
            nums2Right = nums2[partition + 1] if partition + 1 < len(nums2) else float("inf")

            if nums1Left <= nums2Right and nums2Left <= nums1Right:
                if average:
                    return (max(nums1Left, nums2Left) + min(nums1Right, nums2Right)) / 2
                else:
                    return min(nums1Right, nums2Right)
            elif nums1Left > nums2Right:
                r = mid - 1
            else:
                l = mid + 1