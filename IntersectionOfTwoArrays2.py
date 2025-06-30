from typing import List
# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         hashmap = {}
#         res = []
#         for n in nums1:
#             hashmap[n] = hashmap.get(n,0)+1
#         for n in nums2:
#             if n in hashmap and hashmap[n] > 0:
#                 res.append(n)
#                 hashmap[n]-=1
#                 if hashmap[n] == 0:
#                     hashmap.pop(n)
#         return res

# class Solution:
#     def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         nums1 = sorted(nums1)
#         nums2 = sorted(nums2)
#         res = []
#         p1,p2=0,0
#         while p1<len(nums1) and p2<len(nums2):
#             if nums1[p1] < nums2[p2]:
#                 p1+=1
#             elif nums1[p1] > nums2[p2]:
#                 p2+=1
#             else:
#                 res.append(nums1[p1])
#                 p1+=1
#                 p2+=1
#         return res


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1, n2 = len(nums1), len(nums2)
        if n1>n2:
            return self.intersect(nums2,nums1)
        def binarysearch(nums,l,h,target):
            while l<=h:
                mid = l+(h-l)//2
                if nums[mid] == target:
                    if l == mid or nums[mid] >nums[mid-1]:
                        return mid
                    else:
                        h = mid-1
                elif nums[mid]>target:
                    h = mid-1
                else:
                    l = mid+1
            return -1
        res = []
        l,h=0,n2-1
        nums1.sort()
        nums2.sort()
        for i in range(n1):
            curr = nums1[i]
            bsindex = binarysearch(nums2,l,h,curr)
            if bsindex!=-1:
                res.append(nums2[bsindex])
                l = bsindex+1

        return res

        

        
        