"""
Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
"""

# Approach - 1
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        We will be using hashmap for this problem, first we will add all the integers of nums1 array with its frequency 
        then for second time we will check the nums2. 
        Time Complexity : O(n+m), n = len(nums1); m= len(nums2)
        Space Complexity : O(n) or O(m) 
        """
        m, n = len(nums1), len(nums2)
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
        
# Approach - 2

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Using two pointer approach
        Time Complexity : O(mlogm) or O(nlogn) the one which is greater.
        space Complexity : O(n + m)
        """
        m, n = len(nums1), len(nums2)
        nums1.sort()
        nums2.sort()
        res = []
        if m > n :
            return self.intersect(nums2, nums1)
        
        pt1, pt2 = 0, 0
        
        while pt1 < m and pt2 < n:
            if nums1[pt1] == nums2[pt2]:
                res.append(nums1[pt1])
                pt1 += 1
                pt2 += 1
                
            elif nums1[pt1] > nums2[pt2]:
                pt2 += 1
            else:
                pt1 += 1 
                
        return res
                
# Approach - 3

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        Using binary search
        Time Complexity : same as above
        Space Complexity : same as above
        """
        m, n = len(nums1), len(nums2)
        nums1.sort()
        nums2.sort()
        res = []
        if m > n :
            return self.intersect(nums2, nums1)
       
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
                
                        
                
            
                
        
        
        
        


            
                
        
        
        
           