# Time Complexity : O(n1 + n2) considering arrays are sorted
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Two pointer solution
"""
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        p1 = 0
        p2 = 0
        n1 = len(nums1)
        n2 = len(nums2)
        nums1.sort()
        nums2.sort()
        ans = []

        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                ans.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1

        return ans

# Time Complexity : O(n2logn1) considering arrays are sorted
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
Loop through the bigger array and find the element by binary search in smaller array.
"""
class Solution(object):
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if arr[mid] == target:
                if low == mid or arr[mid] > arr[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """


        n1 = len(nums1)
        n2 = len(nums2)

        if n2 > n1:
            return self.intersect(nums2, nums1)


        p1 = 0
        p2 = 0
        nums1.sort()
        nums2.sort()
        ans = []

        low = 0
        high = n1-1

        for i in range(0,n2):
            b_index = self.binarySearch(nums1, low, high, nums2[i])
            if b_index != -1:
                ans.append(nums2[i])
                low = b_index + 1

        return ans













