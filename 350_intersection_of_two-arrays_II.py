'''

## Problem 350: Intersection of two arrays II

## Author: Neha Doiphode
## Date:   06-11-2022

## Description:
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

## Examples
    Example 1:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]

    Example 2:
        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]
        Explanation: [9,4] is also accepted.

## Constraints:
    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

## Follow up:
    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''


from typing import List, Optional

def get_input():
    print("Enter the list 1 of integers(with spaces): ", end = "")
    inp = input()
    inp1 = [int(val) for val in inp.split()]

    print("Enter the list 2 of integers(with spaces): ", end = "")
    inp = input()
    inp2 = [int(val) for val in inp.split()]

    return inp1, inp2

class Solution:
    def intersect_with_hashmaps(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Time complexity : O(m + n) where m is length of list 1 and n is length of list 2. as we traverse over both lists.
        Space complexity: O(m + n) as we create two auxiliary hash maps with keys in list1 and list2.
        '''
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        map1 = {}
        for num in nums1:
            if num not in map1:
                map1[num] = 1
            else:
                map1[num] += 1

        map2 = {}
        for num in nums2:
            if num not in map2:
                map2[num] = 1
            else:
                map2[num] += 1

        result = []
        for key, count in map1.items():
            if key in map2.keys():
                cnt = min(count, map2[key])
                while cnt:
                    result.append(key)
                    cnt -= 1

        return result

    def intersect_with_sorting(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Time complexity : O(n log n + m log m + n + m), as we sort both lists and then traverse over them with 2 pointers.
        Space complexity: O(1) No auxiliary space is used.
        '''
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        nums1.sort()
        nums2.sort()

        ptr1 = ptr2 = 0
        result = []

        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1] == nums2[ptr2]:
                result.append(nums1[ptr1])
                ptr1 += 1
                ptr2 += 1
            elif nums1[ptr1] < nums2[ptr2]:
                ptr1 += 1
            else:
                ptr2 += 1

        return result


# Driver code
solution = Solution()
inp1, inp2 = get_input()
print("Input lists are: ")
print(f"List 1: {inp1}")
print(f"List 2: {inp2}")
print(f"Approach 1: With hash maps: Intersection of the two lists: {solution.intersect_with_hashmaps(inp1, inp2)}")
print(f"Approach 2: With sorting:   Intersection of the two lists: {solution.intersect_with_hashmaps(inp1, inp2)}")
