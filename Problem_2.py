"""
Time Complexity : For hashmap solution- O(m+n), for 2 pointer solution O(m+n)- if array is sorted, 
for binary seearch solution O(mlogn)- if array is sorted and where m is size of smaller array
Space Complexity : O(m) where m is size of smaller array- for hashmap solution, for 2 pointer and binary search
, its O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Here, I have implemented 3 solutions, using hashmaps, using 2 pointers and using binary search. For the original
case when we have unsorted arrays, hashmap solution is the best because of the time complexity. In case
we have sorted arrayas and bigger arrays, binary search solution gives better results. If we have very smaller
arrays, hashmap solution gives better results. In case of hashmap, we put the smaller array values
inside a hashmap and then traverse through the bigger array and whenever we find a common vaue, we put it inside
the result and decrement the count from hashmap. Similarly, in 2 pointer approch, if we find a match, we
append inside result, and move the pointer whichever has lesser value. For binary search approach, we traverse
through the smaller array and do binary search on longer array. If we find a match, append inside result and 
increment the low pointer to 1 plus the index of match found. Also, whenever we find a match, we want to get the
leftmost value of it, so we check for boundaries and perform binary search until we find the leftmost value.
"""


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        l1 = len(nums1)
        l2 = len(nums2)
        if l1 > l2:
            return self.intersect(nums2, nums1)
        result = []
        nums1.sort()
        nums2.sort()
        low = 0
        for i in nums1:
            res = self.binarySearch(nums2, low, l2-1, i)
            if res != -1:
                low = res+1
                result.append(nums2[res])
        return(result)

    def binarySearch(self, nums, low, high, target):
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1

# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         l1=len(nums1)
#         l2=len(nums2)
#         if l1>l2:
#             self.intersect(nums2,nums1)
#         result=[]
#         nums1.sort()
#         nums2.sort()
#         p1=0
#         p2=0
#         while p1<l1 and p2<l2:
#             if nums1[p1]==nums2[p2]:
#                 result.append(nums1[p1])
#                 p1+=1
#                 p2+=1
#             elif nums1[p1]<nums2[p2]:
#                 p1+=1
#             else:
#                 p2+=1
#         return result

# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         l1=len(nums1)
#         l2=len(nums2)
#         if l1>l2:
#             self.intersect(nums2,nums1)
#         result=[]
#         dictt={}
#         for i in nums1:
#             if i not in dictt:
#                 dictt[i]=1
#             else:
#                 dictt[i]+=1
#         for i in nums2:
#             if i in dictt:
#                 result.append(i)
#                 dictt[i]-=1
#                 if dictt[i]==0:
#                     dictt.pop(i)
#         return result
