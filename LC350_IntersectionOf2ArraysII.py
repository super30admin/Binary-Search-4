"""
M1 :
We will create a hashmap of the smaller array and check for all the elements in the larger array if they are there in the hashmap.
Once we find the element, we reduce its count.
TC = O(m+n) 
SC = O(n) - Smaller as we are making the hashmap for smaller list

"""
class Solution:
      
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums2)< len(nums1):
            return self.intersect(nums2, nums1)
        hmap= {}
        for i in range(len(nums1)):
            if nums1[i] in hmap:
                hmap[nums1[i]]+=1
            else:
                hmap[nums1[i]] = 1
        print(hmap)
        result = []      
        for i in range(len(nums2)):
            if nums2[i] in hmap and hmap[nums2[i]]>0:
                result.append(nums2[i])
                hmap[nums2[i]]-=1
            
        return result
        

"""
M2 : if we have sorted arrays

if we are given sorted arrays, start with two pointers pointing at the beginning of the two arrays. If the values match, we add it to the result and move both pointers, 
if the values dont match we move the pointer at the smaller element

TC = O(m+n) 
SC = O(1)

"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        s1 = 0
        s2 = 0
        l1 = len(nums1)
        l2 = len(nums2)
        
        result = []
        while s1<l1 and s2<l2:
            if nums1[s1]==nums2[s2]:
                result.append(nums1[s1])
                s1+=1
                s2+=1
            else:
                if nums1[s1]<nums2[s2]:
                    s1+=1
                else:
                    s2+=1
                    
        return result
"""
M3 : 
Binary Search elements from smaller array in the bigger array

how will we handle duplicates? an element occuring twice in smaller array may be found if searched in larger array even if it occurs only once
So we update the low of the binary search to skip the already traversed elements every time we find an element

TC = O(mlogn) -  m is the smaller array, n is the bigger array
SC = O(1)
"""

class Solution:
   # binary search approach
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        if (len(nums2)<len(nums1)):
            return self.intersect(nums2, nums1)
        
        result = []
        low = 0
        high = len(nums2) -1 
        
        for i in range(len(nums1)):
            bsIndex = self.binarySearch(nums1[i], nums2 , low, high)
            if bsIndex!=-1:
                result.append(nums1[i])
                low = bsIndex + 1
        return result
    
    
    def binarySearch(self, element: int, nums:[int], low: int, high : int):
        while low<=high:
            mid = low +(high-low)//2
            if nums[mid]==element:
                if mid == low or nums[mid-1] != nums[mid]:
                    return mid
                else:
                    high = mid -1
            elif nums[mid]<element:
                low = mid+1
            else:
                high = mid-1
        return -1



        