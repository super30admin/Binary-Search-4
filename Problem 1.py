# Time Complexity: O(logn+logm+mlogn)
# Space Complexity: O(1)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        ans = []
        low = 0
        high = len(nums2) - 1
        for i in nums1:
            bs_index = self.binary_search(nums2, i, low, high)
            if bs_index != -1:
                low = bs_index + 1
                ans.append(i)
        return ans
            
    def binary_search(self, arr, target, low, high):
        while low <= high:
            mid = low + (high-low)/2
            if arr[mid] == target:
                if mid == low or arr[mid-1] < arr[mid]:
                    return mid
                else:
                    high = mid - 1
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1


                
            
            
