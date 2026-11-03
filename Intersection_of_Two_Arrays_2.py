# Time Complexity : O(m+n)
# Space Complexity : O min(m,n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap. Iterate over the smaller array and add the frequencies in HashMap
# Then iterate over the larger array and check if the element is in HashMap if it is then decrement the count by 1
# If the count becomes 0 then remove the element from HashMap
# Append the element to result array
# Return result array


class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        numdict = {}
        result = []
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        for i in range(len(nums1)):
            if nums1[i] not in numdict:
                numdict[nums1[i]] = 1
            else:
                numdict[nums1[i]] += 1
        for i in range(len(nums2)):
            if nums2[i] in numdict:
                numdict[nums2[i]] -= 1
                result.append(nums2[i])
                if numdict[nums2[i]] == 0:
                    del numdict[nums2[i]]
        return result
#Time - O(m+n)
#Space - O(min(m,n))

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        p1 = 0
        p2 = 0
        nums1.sort()
        nums2.sort()
        result = []
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                p1 += 1
            elif nums1[p1] > nums2[p2]:
                p2 += 1
            else:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
        return result
#Time - O(m+n)
#Space - O(1)

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        nums1.sort()
        nums2.sort()
        result = []
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        start = 0
        for num in nums1:
            left = start
            right = len(nums2)-1
            index = self.binarySearch(nums2, num, left, right)
            if index != -1:
                result.append(nums2[index])
                start = index + 1
        return result
    
    def binarySearch(self, nums2, num, left, right):
        index = -1
        while left <= right:
            mid = left + (right-left) // 2
            if num == nums2[mid]:
                index = mid
                right = mid - 1
            elif num > nums2[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return index