"""
Approach: Hashmap

We will first fill the hashmap with the elements of smaller array as key and their frequencies as value.

Then we will traverse the bigger array and if any element from it is present in our hashmap we decrease its count from hashmap and add to our result list. Also if count becomes zero then remove it.

TC: O(m+n)
SC: O(m)

n = size of the bigger array
m = size of the smaller array
"""
from collections import Counter
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 == None or nums2 == None or len(nums1) == 0 or len(nums2) == 0:
            return []
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)
        
        hmap = Counter(nums1)
        
        # for i in nums1:
        #     if i not in hmap:
        #         hmap[i] = 1
        #     else:
        #         hmap[i] += 1

        print(hmap)
        result = [] 
        for i in nums2:
            if i in hmap:
                result.append(i)
                hmap[i] -= 1
                if hmap[i] == 0:
                    del hmap[i]
                    
        return result
    
"""
Approach: Binary Search

We sort both the arrays
We will traverse through the smaller array.

Now the first occurence of the element we encountered will be searched in the bigger array. If we find its occurence then we add it to resultant array. 

Now here it may also possible that may be two copies of the same element is present in the bigger array. For example

nums1 = [1,1,2,2,3,4,5]
nums2 = [2,2,4]

Here as we can see we have two copies of 2 in nums1. So if we find the first 2 then we need to ensure we do not consider it again but consider the second 2. 

To achieve this we will add an additonal logic in binary search which is if we find an element equal to our target during binary search we will check that if the there is any similar element before it which yet to be considered.

if low == mid or nums2[mid-1] < nums2[mid]:
    return mid
else:
    high = mid - 1

TC: O(nlogn) 
SC: O(1)

n = size of the bigger array
m = size of the smaller array
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if nums1 == None or nums2 == None or len(nums1) == 0 or len(nums2) == 0:
            return []
        
        n1 = len(nums1)
        n2 = len(nums2)
            
        if n1 > n2:
            return self.intersect(nums2, nums1)
        
        nums1.sort()
        nums2.sort()
        low = 0
        result = []
        
        # O(mlogn)
        for num in nums1:
            pos = self.binary_search(nums2, low, n2 - 1, num);
            
            if pos != -1:
                result.append(num)
                low = pos + 1
                
        return result
    
    def binary_search(self, nums2, low, high, target):
        
        while low <= high:
            mid = low + (high-low) // 2
            
            if nums2[mid] == target:
                if low == mid or nums2[mid-1] < nums2[mid]:
                    return mid
                else:
                    high = mid - 1
            
            elif target > nums2[mid]:
                low = mid + 1
                
            else:
                high = mid - 1
                
        return -1
                
            
        