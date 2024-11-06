# 350. Intersection of Two Arrays II
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)

        nums1 = sorted(nums1)
        nums2 = sorted(nums2)

        def binarySearch(low,high,target,arr):
            while low <= high:
                mid = low + (high-low)//2
                if arr[mid] == target:
                    if arr[mid-1] != target:
                        return mid
                    else:
                        while arr[mid] == arr[mid-1]:
                            mid = mid - 1
                        return mid
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            return -1


        result = []
        low = 0 
        high = len(nums2)-1
        for n in nums2:
            ind = binarySearch(low,high,n,nums2)
            if ind:
                low = ind

        return result
        