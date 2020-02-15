from math import inf


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
            https://leetcode.com/problems/median-of-two-sorted-arrays/
            Time Complexity - O(log(min(x,y))
            Space Complexity - O(1)
            'm' is the length of nums1, 'n' is the length of nums2
        """
        # start from the smaller list
        if len(nums2) < len(nums1):
            nums1, nums2 = nums2, nums1

        x = len(nums1)
        y = len(nums2)

        # binary search on nums1
        low, high = 0, x
        while low <= high:
            partitionX = (low + high) / 2
            # 1 is added to ease for both odd and even case
            partitionY = (x + y + 1) / 2 - partitionX

            # if partitionX is 0 it means nothing is there on left side.
            # Use -INF for maxLeftX
            maxLeftX = -inf if partitionX == 0 else nums1[partitionX - 1]
            # if partitionY is length of input then there is nothing on right side.
            # Use +INF ofr minRightX
            minRightX = inf if partitionX == x else nums1[partitionX]

            maxLeftY = -inf if partitionY == 0 else nums2[partitionY - 1]
            minRightY = inf if partitionY == y else nums2[partitionY]

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                # we have partitioned list at correct place
                # Now get max of left elements and min of right elements
                # to get the median in case of even length of comined list size
                if (x + y) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
                else:
                    return max(maxLeftX, maxLeftY)
            # we are too far on right side for partition X, Go left side
            elif maxLeftX > minRightY:
                high = partitionX - 1
            # we are too far on left side for partition X, Go right side
            else:
                low = partitionX + 1
        # we can come here is if input lists are not sorted
        raise Exception('Invalid Input')

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
            https://leetcode.com/problems/median-of-two-sorted-arrays/
            k = m+n
            Time Complexity - O(klogk)
            Space Complexity - O(n)
            'm' is the length of nums1, 'n' is the length of nums2
        """
        nums1 += nums2
        nums1.sort()
        mid = len(nums1) // 2
        if len(nums1) % 2 == 0:
            return (nums1[mid - 1] + nums1[mid]) / 2
        else:
            return nums1[mid]
