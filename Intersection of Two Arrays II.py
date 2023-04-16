# Time Complexity : O(mlogn) m = len(nums)1, n = len(nums2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

#hash map and two pointers can also be used

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
		#sort assuming arrays are already sorted as follow up question
        nums1.sort()
        nums2.sort()

        result = []
        low = 0
        high = len(nums2) - 1

        for i in range(len(nums1)):
            bidx = self.binarySearch(nums2, nums1[i], low ,high)
            if bidx >= 0:
                result.append(nums1[i])
                low = bidx + 1

        return result

        

    def binarySearch(self, nums2, key, low, high):
        while low <= high:
            mid = (low+high)//2
            print(key,low,high,nums2[mid])
            if nums2[mid] == key:
                if mid > low and nums2[mid] == nums2[mid-1]:
                    high = mid - 1
                else:
                    return mid
            elif nums2[mid] > key:
                high = mid - 1
            else:
                low = mid + 1
        return -1

        
            

        