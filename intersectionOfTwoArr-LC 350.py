# Binary Search Solution
# Time Complexity = O(m log m) + O(n log n) + O(m log n), m = nums1(smaller), n = nums2
# Space Complexity = O(1)

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n2 < n1:
            return self.intersect(nums2, nums1)
        
        # Result arr
        result = []
        
        # Since the arrays are not sorted, we need to sort the in order to implement our 2 ptr solu
        # TC = n1 log n1, n2 log n2
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        # Iterate over the smaller array and do a binary search on the larger array
        low = 0
        # TC = n1 log n2
        for i in range(n1):
            bIndex = self.binarySearch(nums2, low, n2 - 1, nums1[i])
            if bIndex != -1:        # i.e if bIndex is valid
                result.append(nums1[i])
                low = bIndex + 1
        
        
        return result
                
                
                
    
    def binarySearch(self, nums, low, high, target):
        while(low <= high):
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if (mid == low or nums[mid - 1] < nums[mid]):
                    return mid
                
                high = mid - 1
            
            elif (target < nums[mid]):
                high = mid - 1          # Move left
                
            else:
                low = mid + 1           # Move right
                
                
        return -1
        
        


# 2 pointers solution
# Time Complexity = O(m log m) + O(n log n), m = nums1, n = nums2
# Space Complexity = O(1)

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n2 < n1:
            return self.intersect(nums2, nums1)
        
        # Initialising 2 pointers
        p1 = 0          # For nums1
        p2 = 0          # For nums2
        
        # Result arr
        result = []
        
        # Since the arrays are not sorted, we need to sort the in order to implement our 2 ptr solu
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        while(p1 < n1 and p2 < n2):
            if nums1[p1] < nums2[p2]:
                p1 += 1         # Move p1
            elif nums1[p1] > nums2[p2]:
                p2 += 1         # Move p2
            else:
                result.append(nums1[p1])
                p1 += 1         # Move both when the elements are equal and a match
                p2 += 1
                
            
            
        return result




# Hashmap Solution
# Time Complexity = O(m + n), where m is the len of nums1 and n is the len of nums2
# Space Complexity = O(1)

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        # If in case nums2 is the smaller array, then call the function with the below arguments
        if n2 < n1:
            return self.intersect(nums2, nums1)
        
        # Initialising hashmap and result arr
        hashMap = {}
        result = []
        
        # Creating a hashmap for storing the count of each element in the small array
        for num in nums1:
            if num not in hashMap:
                hashMap[num] = 1
            else:
                hashMap[num] += 1
                
        # Now doing a binary search on nums2(larger array)
        for num in nums2:
            if num in hashMap:
                result.append(num)
                hashMap[num] -= 1
                if hashMap[num] == 0:
                    hashMap.pop(num)
                    
                    
        return result
        
       