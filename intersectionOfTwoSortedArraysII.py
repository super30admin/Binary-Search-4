#Time Complexity : O(nlog(n) + mlogm + nlogm) where n is the length of the smaller array out of both input arrays and m is the length of the longer array
#Space Complexity : O(m+n) -> To store the sorted
#Did this code successfully run on Leetcode : Yes


class Solution:

    def binarySearch(self, arr, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            #check if we are the left most element incase of repeating elements
            if arr[mid] == target:
                if mid == low or arr[mid-1] < arr[mid]:
                    return mid
                else:
                    high = mid-1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #perform binary search on larger array always
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        result = []
        index = 0
        #iterate through the smaller array
        for num in nums1:
            #perform binary search to find the left most element in the larger array
            ind = self.binarySearch(nums2, index, len(nums2)-1, num)
            #if we find the target then append to the result and move the pointer to of low for the binary search to the found index target plus one
            if ind != -1:
                result.append(num)
                index = ind + 1

        return result
