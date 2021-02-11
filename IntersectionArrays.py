# Hashmap
# TC: O(n+m) lengths of arrays
# SC: O(m) m - length of shorter array
# Store values of shorter array elements with their frequency(to reduce space). Iterate over longer array- if hashmap elements found -append value to result array and reduce freq & del num from hashmap if freq = 0.
class Solution:
    def intersect(self, nums1, nums2):
        # edge
        if not nums1 or not nums2: return []
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: return self.intersect(nums2, nums1)
        result = []
        hashmap = {}
        for num in nums1:
            if num in hashmap:
                hashmap[num] += 1
            else:
                hashmap[num] = 1
        for num in nums2:
            if num in hashmap:
                result.append(num)
                hashmap[num] -= 1
                if hashmap[num] == 0:
                    del hashmap[num]       
        return result

# Suppose arrays are sorted

# Two pointers
# TC: O(n)
# SC: O(1)
# Place pointers at start of arrays. If equal values append to result. Increment the pointer with the smaller value as the array is not sorted- we are not going to encounter this smaller value again in the other array.
class Solution:
    def intersect(self, nums1, nums2):
        # edge
        if not nums1 or not nums2: return []
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: return self.intersect(nums2, nums1)
        result = []
        l1, l2 = 0, 0
        while l1 < n1 and l2 < n2:
            if nums1[l1] == nums2[l2]:
                result.append(nums1[l1])
                l1 += 1
                l2 += 1
            elif nums1[l1] < nums2[l2]:
                l1 += 1
            else:
                l2 += 1
        return result

# Binary search
# TC: O(mlogn) len(m) > len(n)
# SC: O(1)
# Iterate over shorter array and perform binary search on the longer array such that u find the left most element that matches. For the next search we move low by 1 to evade considering same number in case of duplicates.
class Solution:
    def intersect(self, nums1, nums2):
        # edge
        if not nums1 or not nums2: return []
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: return self.intersect(nums2, nums1)
        result = []
        low = 0
        for i in range(n1):
            bsIdx = self.binarySearch(nums2, nums1[i], low, n2-1)
            if bsIdx != -1:
                result.append(nums1[i])
                low = bsIdx + 1
        return result
    
    def binarySearch(self, nums, x, low, high):
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == x:
                # check if very first index
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid -1
            elif nums[mid] > x:
                high = mid -1
            else:
                low = mid + 1
        return -1

