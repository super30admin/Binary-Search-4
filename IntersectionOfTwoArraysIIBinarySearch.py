'''
TC: O(mlogm+nlogm) where m is the max length of nums1 and nums2
    and n is the number of number of elements in the smaller array
SC: O(m+n) Considering the nums are not sorted. 
    If already sorted, it will be O(1)
'''
from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        def binarySearch(i,j, target):
            while i<j:
                mid = (i+j)//2
                if nums1[mid] == target:
                    j = mid
                elif nums1[mid]<target:
                    i=mid+1
                else:
                    j = mid
            if i<len(nums1) and nums1[i] == target:
                return True, i
            else:
                return False, None

        if len(nums1) < len(nums2):
            nums2,nums1 = nums1, nums2
        nums1.sort()
        nums2.sort()
        res = []
        a,b = -1, len(nums1)-1
        for n in nums2:
            if a!=None:
                temp = a
            flag, a = binarySearch(temp+1,b, n)
            if flag:
                res.append(n)
        return res
s = Solution()
print(s.intersect([1,2,2,1], [2,2]))
print(s.intersect([4,9,5], [9,4,9,8,4]))
print(s.intersect([1,2], [1,1]))
print(s.intersect([9,1], [7,8,3,9,0,0,9,1,5]))
print(s.intersect([43,85,49,2,83,2,39,99,15,70,39,27,71,3,88,5,19,5,68,34,7,41,84,2,13,85,12,54,7,9,13,19,92], [10,8,53,63,58,83,26,10,58,3,61,56,55,38,81,29,69,55,86,23,91,44,9,98,41,48,41,16,42,72,6,4,2,81,42,84,4,13]))