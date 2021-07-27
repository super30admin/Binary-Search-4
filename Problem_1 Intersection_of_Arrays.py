# // Time Complexity : O(m+n) where n and m are smaller and larger array respectively
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Hashmap Approach
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        result = []
        if n1 > n2:
            # Interchange nums1 and num2 as we want nums1 to be smaller array
            return self.intersect(nums2, nums1)
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

# // Time Complexity : O(min(m,n)) where n and m are smaller and larger array respectively
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Hashmap Approach
#2 Pointer

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        result = []
        if n1 > n2:
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        p1 = 0
        p2 = 0
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

# // Time Complexity : O(nlogm) where n and m are smaller and larger array respectively
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Binary Search
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        result = []
        if n1 > n2:
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        low = 0
        high = n2 - 1
        #Iterate over the samaller array
        for i in range(n1):
            curr = nums1[i]
            bs_index = self.binarysearch(nums2, low, high, curr)
            if bs_index != -1:
                #Num is present at some index
                result.append(curr)
                low = bs_index + 1
        return result

    def binarysearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                if mid == low or arr[mid] > arr[mid - 1]:
                    #very first Index or left most value
                    return mid
                else:
                    #Keep moving left
                    high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1



