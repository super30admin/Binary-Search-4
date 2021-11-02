# Brute force solution using hashmap on smaller array
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.intersect(nums2, nums1)
        result = []
        hashmap = {}
        for num in nums1:
            hashmap[num] = hashmap.get(num, 0) + 1
        for num in nums2:
            if num in hashmap.keys():
                result.append(num)
                hashmap[num] -= 1
                if hashmap[num] == 0:
                    hashmap.pop(num)
        return result

# Time Complexity: O(n1+n2)
# Space Complexity: O(n1) where n1 is smaller length array



# Two Pointer Solution if arrays are already sorted
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        p1, p2 = 0, 0
        result = []
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result

# Time Complexity: O(n1) where n1 is smaller array
# Space Complexity: O(1)



# Binary Search Solution
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        low, high = 0, n2-1
        result = []
        for num in nums1:
            bsIndex = self.binarySearch(nums2, low, high, num)
            if bsIndex != -1:
                result.append(num)
                low = bsIndex + 1
        return result
    
    def binarySearch(self, nums2, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if nums2[mid] == target:
                if mid == low or nums2[mid-1] < nums2[mid]:
                    return mid    
                else:
                    high = mid -1
            elif nums2[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

# Time Complexity : O(n1 * log(n2))
# Space Complexity : O(1)
                