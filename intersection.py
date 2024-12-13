# The intersect method finds the intersection of two arrays.

# Sort both arrays to enable two-pointer traversal.
# Use pointers 'i' and 'j' to compare elements in nums1 and nums2:
# - If equal, add the element to the result and increment both pointers.
# - If nums1[i] < nums2[j], increment 'i'.
# - Otherwise, increment 'j'.

# Return the result list containing the intersection elements.

# TC: O(n log n + m log m) - Sorting nums1 and nums2, where n and m are their lengths.
# SC: O(1) - Constant space (result list excluded).


class Solution(object):
    def intersect(self, nums1, nums2):
        nums1.sort()
        nums2.sort()
        ans = []
        i, j = 0, 0
        n, m = len(nums1), len(nums2)
        while i < n and j < m:
            if nums1[i] == nums2[j]:
                ans.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1
        return ans