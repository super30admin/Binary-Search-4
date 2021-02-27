#                      Hashmap    sorted: Two Pointers  Sorted: Binary search     
#============================================================================
# // Time Complexity : O(n+m)        O(m+n)                 O(mlon(n)) [best for larger values] 
# // Space Complexity : O(m)          O(1)                  O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# 1. Binary search 
# for every element in small array do Binary search
# for each search increase the low if we have found the value

# 2. Two Pointer
# use pointers at head of both the lists check if we get the match otherwise move forward

# 3. Hashmap
# run for loop on small array and put all element and its counts in hashmap
# run for loop on bigger array and look in presense of that element in map and decrease its count if found

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1<n2: self.intersect(nums2, nums1) 
        # nums2 is smaller 
        # nums1 is larger
        nums1.sort()
        nums2.sort()
        res =[]
        low = 0
        high = n1
        index = 0
        
        #run for loop on small array
        for i in nums2:
            #biindex will get the index return from func
            bindex = self.binarySearch(nums1, index, high-1, i)
            if bindex != -1:
                res.append(i)
                index = bindex + 1
        return res
                
        
    
    def binarySearch(self, arr, low, high, target):
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[mid] == target:
                # This is for repetative values in the arrays
                # if target is at oth index or arr[mid] is first targer then return
                if mid == low or arr[mid] > arr[mid-1]:
                    return mid
                # if false means there are repetative values in the array
                else:
                    high = mid - 1
                    
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1
            
            
            
            
            
            
            
            
            
            
        
#         USING TWO POINTERS
#         while index<n2 and left<n1:
#             if nums1[left] == nums2[index]:
#                 res.append(nums1[left])
#                 index += 1
#                 left += 1
                
#             elif nums1[left] > nums2[index]:
#                 index += 1
            
#             elif nums1[left] < nums2[index]:
#                 left += 1
                
#         return res
        
        




        #        
#         for i in nums2:
#             if i not in hashmap:
#                 hashmap[i] = 0
#             hashmap[i] += 1
        
#         for j in nums1:
#             if j in hashmap:
#                 res.append(j)
#                 hashmap[j] -= 1
#                 if hashmap[j] == 0:
#                     del hashmap[j]
#         return res
            