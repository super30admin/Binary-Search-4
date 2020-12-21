#Time Complexity : ?? i am confused what will be the time complexity
#Space Complexity : O(m+n)
#https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #making num1 larger and doing binary search on larger part
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort() # nlogn
        nums2.sort() # mlogm
        result = []
        index = 0
        #iterate through the smaller array
        for num in nums1:
            #finding left most element in the larger array
            idx = self.binarySearch(nums2, index, len(nums2)-1, num) # every n element logm?

            if idx != -1:
                result.append(num)# means number found and appending num in result
                index = idx + 1# increasing index only when number found

        return result
    
    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if arr[mid] == target:
                if mid == low or arr[mid-1] < arr[mid]: # chking lft most element
                    return mid
                else:
                    high = mid-1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1