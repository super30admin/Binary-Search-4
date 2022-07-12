'''
Time Complexity: O(m + n)
Space Complexity: O(m + n)
Run on Leetcode: YES
'''
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        hMap = {}
        result = []
        if len(nums1) <= len(nums2):
            for num in nums1:
                if num in hMap.keys():
                    hMap[num] += 1
                else:
                    hMap[num] = 1
            for num in nums2:
                if num in hMap.keys():
                    if hMap[num] > 0:
                        result.append(num)
                        hMap[num] -= 1
        else:
            for num in nums2:
                if num in hMap.keys():
                    hMap[num] += 1
                else:
                    hMap[num] = 1
            for num in nums1:
                if num in hMap.keys():
                    if hMap[num] > 0:
                        result.append(num)
                        hMap[num] -= 1
        return result