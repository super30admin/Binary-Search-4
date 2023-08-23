# Time Complexity : O(slogb)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        def binarySearch(s_arr, b_arr, l, h, target):
            while l <= h:
                mid = (l + h) // 2
                if s_arr[mid] == target:
                    if mid == l or s_arr[mid] != s_arr[mid - 1]:
                        return mid
                    else:
                        h = mid - 1
                elif s_arr[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1

        if len(nums1) > len(nums2):
            s = nums2
            b = nums1
        else:
            s = nums1
            b = nums2

        s.sort()
        b.sort()
        
        res = []
        l = 0

        for num in s:
            index = binarySearch(s, b, l, len(b) - 1, num)
            if index != -1:
                res.append(num)
                l = index + 1

        return res