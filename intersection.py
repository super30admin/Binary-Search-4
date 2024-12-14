"""
Approach1: using hmap. store one of the arrays in hmap along with frequency. then traverse the second and check
if present, if yes add to ans and reduce freq. if freq becomes 0 remove.
TC: max O(m,n) SC: O(m)
Approach2:
sort the array and use 2 pointers
TC: O(nlogn) + O(m+n)
Approach3:
binary search
"""


class Solution_binary_search:
    def binary_search(self, target, lo, hi, arr):

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            if arr[mid] == target:
                # check if it is first occurrence: either lo == mid or curr element not equal to previous elemet
                # if yes return the idx
                # if not update hi
                if lo == mid or arr[mid] != arr[mid - 1]:
                    return mid
                else:
                    hi = mid - 1

            elif arr[mid] < target:
                lo = mid + 1

            elif arr[mid] > target:
                hi = mid - 1

        return -1

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        ans = []
        nums1.sort()
        nums2.sort()
        if len(nums1) < len(nums2):
            nums1, nums2 = nums2, nums1  # smaller is num2

        lo = 0
        hi = len(nums1)
        ans = []
        for num in nums2:
            idx = self.binary_search(num, lo, len(nums1) - 1, nums1)
            if idx != -1:
                ans.append(num)
                lo = idx + 1

        return ans


class Solution_sort:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        i, j = 0, 0
        ans = []
        nums1.sort()
        nums2.sort()

        while i < len(nums1) and j < len(nums2):
            if nums2[j] == nums1[i]:
                ans.append(nums2[j])
                i += 1
                j += 1

            elif nums2[j] > nums1[i]:
                i += 1

            elif nums2[j] < nums1[i]:
                j += 1

        return ans


class Solution_hmap:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hmap = {}
        ans = []
        for n in nums1:
            if n not in hmap:
                hmap[n] = 0
            hmap[n] += 1

        for n in nums2:
            if n in hmap:
                ans.append(n)
                hmap[n] -= 1
                if hmap[n] == 0:
                    del hmap[n]

        return ans