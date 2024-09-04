# Binary-Search-4

# Problem 1 Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def binary(low,high,arr,target):
            while low <= high:
                mid = (low + high) //2
                if arr[mid] == target:
                    if mid == low or arr[mid] != arr[mid -1]:
                        return mid
                    else:
                        high = high -1
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        high = len(nums2) - 1
        for i in range(len(nums1)):
            bind = binary(low,high,nums2,nums1[i])
            if bind != -1:
                result.append(nums2[bind])
                low = bind + 1
        return result
#TC = O(n log m), SC = O(1) 

# Problem 2 Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        low = 0
        high = len(nums1)

        while low <= high:
            xpart = low + (high-low) // 2
            ypart = int((len(nums1) + len(nums2))/2) - xpart

            l1 = float('-inf') if xpart == 0 else nums1[xpart - 1]
            l2 = float('-inf') if ypart == 0 else nums2[ypart - 1]
            r1 = float('inf') if xpart == len(nums1) else nums1[xpart]
            r2 = float('inf') if ypart == len(nums2) else nums2[ypart]

            if l1 <= r2 and l2 <= r1 :
                if (len(nums1) + len(nums2)) %2 == 0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                else:
                    return min(r1,r2)
            elif l1 > r2:
                high = xpart - 1
            else:
                low = xpart + 1
# TC = O(log(min(m,n))), SC = O(1)