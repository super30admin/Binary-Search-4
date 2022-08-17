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
    def intersect_with_hashmap(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Time complexity : O(m + n) where m is length of list 1 and n is length of list 2. as we traverse over both lists.
        Space complexity: O(min(m,n)) as we create an auxiliary hash map with keys in shorter list.
        '''
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        hashmap = {}
        result = []

        if len(nums1) > len(nums2):
            return self.intersect_with_hashmap(nums2, nums1)

        for num in nums1:
            if num not in hashmap:
                hashmap[num] = 1
            else:
                hashmap[num] += 1

        for num in nums2:
            if num in hashmap and hashmap[num] > 0:
                result.append(num)
                hashmap[num] -= 1

        return result

    def intersect_with_sorting(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Time complexity : O(n log n + m log m + n + m)  ~= O(max(m log m , n log n)), as we sort both lists and then traverse over them with 2 pointers.
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

    def binary_search(self, nums, low, high, key):
        while low <= high:
            mid = low + (high - low) // 2
            if key == nums[mid]:
                # if you are at left most element of the array
                if mid == low or nums[mid - 1] < nums[mid]:
                    return mid
                # Here we try to find the first occurence of a number
                high = mid - 1

            elif key < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def intersect_with_binary_search(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Time complexity : O(m log m + n log n + m * log n),
                                    m log m  : to sort list 1
                                    n log n  : to sort list 2
                                    m * log n: to traverse over shorter list and perform binary search over the longer list.

                                    In our case m < n always, as we are making sure nums1 is always the smaller list.
                                    
        Space complexity: O(1), as we are not using any auxiliary space.
        '''
        if len(nums1) == 0 or len(nums2) == 0:
            return []

        # O(m log m)
        nums1.sort()

        # O(n log n)
        nums2.sort()

        if len(nums1) > len(nums2):
            return self.intersect_with_binary_search(nums2, nums1)

        result = []
        low = 0
        high = len(nums2) - 1

        # Iterate over the smaller array and perform binary search on second array
        # O(m * log n)
        for i in range(len(nums1)):
            b_search_index = self.binary_search(nums2, low, high, nums1[i])
            if b_search_index != -1:
                result.append(nums1[i])
                low = b_search_index + 1

        return result



# Driver code
solution = Solution()
inp1, inp2 = get_input()
print("Input lists are: ")
print(f"List 1: {inp1}")
print(f"List 2: {inp2}")
print(f"Approach 1: With hash maps:   Intersection of the two lists: {solution.intersect_with_hashmap(inp1, inp2)}")
print(f"Approach 2: With sorting  :   Intersection of the two lists: {solution.intersect_with_sorting(inp1, inp2)}")
print(f"Approach 3: Binary search :   Intersection of the two lists: {solution.intersect_with_binary_search(inp1, inp2)}")
