# Time Complexity : O(n) where is the maximum number for elements from list1 or list2
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        # # Method 1
        #         nums2.sort()
        #         res = []

        #         def binarySearch(num):
        #             l = 0
        #             r = len(nums2) - 1
        #             while l <= r:
        #                 mid = (l+r)//2
        #                 if nums2[mid] == num:
        #                     nums2.remove(nums2[mid])
        #                     return True
        #                 elif num > nums2[mid]:
        #                     l = mid + 1
        #                 else:
        #                     r = mid - 1
        #             return False

        #         for num in nums1:
        #             if binarySearch(num):
        #                 res.append(num)
        #         return res

        # Method 2
        num_dct = {}
        res = []
        for i in nums1:
            num_dct[i] = num_dct.get(i, 0) + 1

        for i in nums2:
            if i in num_dct and num_dct[i] > 0:
                num_dct[i] -= 1
                res.append(i)
        return res

# Here I am initially storung the numbers and their counts in the dictionary,then i am iterating over the next list
# and checking if number is present and the count is greater than 0 then I will add the number to the result and
# decrease the counter. Finally, I am returning the result list.