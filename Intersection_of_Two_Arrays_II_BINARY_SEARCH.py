# Created by Aashish Adhikari at 7:30 PM 2/5/2021

'''
Time Complexity:
O(nlogn) for sorting the larger array.
O(m) to traverse the shorter array.
    -At each position in this traversal, binary search on the longer array. O(logn)

# O(nlogn) where n is the length of the longer array.

If w ignore the sorting, O(mlogn).


Space Complexity:
O(m) since we create new variables at each call of the binary search.
'''

class Solution(object):


    def binary_search(self, arr, target, high, low):

        while low <= high:

            mid = low + ((high-low)/2)

            if arr[mid] == target:

                if mid == low or arr[mid] > arr[mid-1]: # VVI: do not check mid == 0, we want to check from the leftmost position for this iteration only,
                    # not the whole array

                    return mid

                else:
                    high = mid-1
            elif arr[mid] < target:
                low = mid+1
            else:
                high = mid-1

        return -1


    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2:
            return self.intersect(nums2, nums1)

        # O(nlogn)
        nums1.sort()
        nums2.sort()

        low = 0
        high = n2-1
        sol = []

        for idx in range(0, n1):

            # check if this element can be matched with an element in nums2
            matching_position = self.binary_search(nums2, nums1[idx], high, low)

            if matching_position != -1:
                sol.append(nums1[idx])


                low = matching_position + 1





        return sol







