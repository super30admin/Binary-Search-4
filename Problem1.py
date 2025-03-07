class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m, n = len(nums1), len(nums2)

        if m > n:
            return self.intersect(nums2, nums1)
        nums2.sort()
        nums1.sort()
        li = []
        low = 0
        high = n -1
        for i in range(m):
            target = nums1[i]
            bsIdx = self.binarysearch(nums2,low,high,target)
            if bsIdx != -1:
                li.append(target)
                low = bsIdx + 1
        return li
    def binarysearch(self,arr: List[int], low: int, high: int, target: int):
        while low <= high:
            mid = low + (high - low)//2
            if arr[mid] == target:
                if mid == low or arr[mid] > arr[mid - 1]:
                    return mid
                else:
                    high = mid - 1

            elif arr[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        
        return -1

