# Assuming sorted inputs question
# Time Complexity : O(n log m)  where n is the length of smaller array and m is the length of longer array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# for each element in smaller array find the left most appearance of the element add it the result and decrease the search space in the longer array by one
# by moving the left by one

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        mapping = defaultdict(lambda:0)
        length1 = len(nums1)
        length2 = len(nums2)
        one = nums1
        two = nums2
        if len(nums1) > len(nums2):
            one, two = nums2, nums1
        result = []
        current_low = 0
        for i in range(len(one)):
            target = one[i]
            idx = self.binary_search(target, two, current_low)
            if idx >= 0:
                result.append(target)
                current_low = idx+1
        return result
    
    
    def binary_search(self, target, arr, low):
        c_low = low
        high = len(arr) - 1
        while c_low <= high:
            mid = c_low + (high - c_low) // 2
            if arr[mid]  == target:
                if mid > low and arr[mid-1] == target:
                    high = mid - 1
                else:
                    return mid
            elif arr[mid] < target:
                c_low = mid+1
            else:
                high = mid - 1
                
        return -1

