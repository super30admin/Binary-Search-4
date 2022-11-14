"""
FAANMG Problem #92 {Easy} 

350. Intersection of Two Arrays II

Time Complexity : O(n+m), n = len(nums1); m= len(nums2)
Space Complexity : O(n) or O(m)
        
Did this code successfully run on Leetcode : Yes

We will be using hashmap for this problem, first we will add all the integers of nums1 array with its frequency 
then for second time we will check the nums2.

@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m, n = len(nums1), len(nums2)
        
        # set the lower length of list to nums1 and other to nums2 
        if m > n :
            return self.intersect(nums2, nums1)

        feq_map = {}
        res = []
        
        # First pass: store all the values of nums1 in hash map first
        for num in nums1:
            if num in feq_map:
                feq_map[num] += 1
            else:
                feq_map[num] = 1
        
        # Second pass : will check the nums of nums2 in hash_map and reduce its count by 1, if         
        for num in nums2:
            if num in feq_map:
                if feq_map[num] > 0 :
                    feq_map[num] -= 1
                    res.append(num)


        return res
        
    
"""
Using two pointer approach
Time Complexity : O(mlogm) or O(nlogn) the one which is greater.
space Complexity : O(n + m)

"""   



class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m, n = len(nums1), len(nums2)
        
        # set the lower length of list to nums1 and other to nums2 
        if m > n :
            return self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()
        res = []
        
        pt1, pt2 = 0, 0
        

        while pt1 < m and pt2 < n:
            if nums1[pt1] == nums2[pt2]:
                res.append(nums1[pt1])
                pt1 += 1
                pt2 += 1

            elif nums1[pt1] < nums2[pt2]:
                pt1 += 1
            else:
                pt2 += 1 

        return res
    
"""
Using binary search

Time Complexity : O(mlogm) or O(nlogn) the one which is greater.
space Complexity : O(n + m)
"""    


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m, n = len(nums1), len(nums2)
        
        # set the lower length of list to nums1 and other to nums2 
        if m > n :
            return self.intersect(nums2, nums1)

        nums1.sort()
        nums2.sort()
        res = []
        
        low = 0

        for i in range(m):
            high = n-1
            while low <= high :
                mid = (low+high)//2
                if nums2[mid] == nums1[i]:
                    if low < mid and nums2[mid - 1] == nums2[mid]:
                        high = mid -1
                    else:
                        res.append(nums2[mid])
                        low = mid +1
                        break

                elif  nums2[mid] > nums1[i]:
                    high = mid - 1
                else:
                    low = mid + 1

        return res
