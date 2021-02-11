# Time Complexity : O(logm)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Binary Search partitions.
# Check the smaller array between nums1 and nums2 and perfom binary search on smaller array
# Initialize the left to 0 and right to length of smaller array and partX will be the mid
# To find partY, the formula is length of both the arrays // 2 - partX
# Once we got the partY we need to combine the left half and right half of both the arrays
# Then l1 is rightmost element of left half in first array that is partX-1
# r1 is leftmost element of right half in first array that is partX
# l2 is rightmost element of left half of second array that is partY-1
# r2 is leftmost element of right half in second array that is partY
# Then we need to check if l2 > r1, increment left pointer to mid + 1 that is partX + 1
# Else decrement the right pointer to mid - 1 that is partX - 1
# If l1 < r2 and l2 < r1 then check if the combined length of both the array is even or odd
# If it is even then return max(l1, l2) + min(r1, r2)
# If it is odd then return min(r1, r2) as the right half will have more elements than the left and median will be in right half


class Solution:
    def findMedianSortedArrays(self, nums1: List[int],
                               nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        left = 0
        right = n1
        while left <= right:
            partX = left + (right - left) // 2  #1
            partY = (n1 + n2) // 2 - partX  #1
            if partX == 0:
                l1 = -inf
            else:
                l1 = nums1[partX - 1]  #1
            if partX == n1:
                r1 = inf
            else:
                r1 = nums1[partX]  #2
            if partY == 0:
                l2 = -inf
            else:
                l2 = nums2[partY - 1]  #3
            if partY == n2:
                r2 = inf
            else:
                r2 = nums2[partY]  #4
            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            else:
                if l2 > r1:
                    left = partX + 1
                else:
                    right = partX - 1
