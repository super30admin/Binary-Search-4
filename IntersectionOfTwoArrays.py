'''
    Time Complexity:
        O(m + n) (where m and n are the lengths of the given arrays)

    Space Complexity:
        O(m) (where m = length of the smaller array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Maintain a counter (HashMap) of the numbers in the smaller array.
        Traverse through the bigger array:
            -> If this number is there in the HashMap and has a count > 0:
                -> Add if to the output list.
                -> Decrement its count in the HashMap.
'''

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        smaller, bigger = nums2, nums1

        if len(smaller) > len(bigger):
            smaller, bigger = bigger, smaller

        num_collection = collections.Counter(smaller)
        commons = []

        for num in bigger:
            available_nums = num_collection[num]

            if available_nums:
                commons.append(num)
                num_collection[num] -= 1

        return commons
