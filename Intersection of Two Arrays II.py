'''
Solution 1: HashMap 
    - iterate over the smaller array, and make a frequency map
    - iterate over the larger array and check if the element is present in frequency
      map. If Yes, we have a common intersection. reduce the frequency in Map. 
Time complexity: O(m+n) - iterating over both arrays
Space complexity; O(min(m,n)) - hashMap on smaller array 
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1) # change order
        
        m = len(nums1)
        n = len(nums2) 

        hashMap = {}
        for i in range(m):
            hashMap[nums1[i]] = hashMap.get(nums1[i],0)
            hashMap[nums1[i]]+=1 # store the frequency
        
        intersection = []

        for i in range(n):
            if nums2[i] in hashMap:
                intersection.append(nums2[i]) # common element of 2 lists
                hashMap[nums2[i]]-=1 # reduce the frequency
                if hashMap[nums2[i]]==0:
                    hashMap.pop(nums2[i]) # remove the key if total matches for this element are done
        
        return intersection


'''
Follow up: If arrays are sorted. 
Solution 2: Binary Search for elements in smaller array on larger array 
    - iterate over the smaller array, and do a binary search in larger array
    - look for leftMost match in larger array for the target. 
    - if we find a match, update the range of next binary search from 
      matched_index+1 to end of nums2 array. 
Time complexity: O(mlogn) - where m<n
Space complexity; O(1)  
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1) # flip
        
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)

        m = len(nums1)
        n = len(nums2)

        intersection = []
        start_index_nums2 = 0 # start index to do binary search on
        for i in range(m):
            found_index = self.binarySearch(nums1[i],nums2,start_index_nums2) # find leftMost
            if found_index!=-1: # we did find the intersection
                intersection.append(nums1[i])
                start_index_nums2 = found_index+1
                if start_index_nums2>=n: # exhausted on nums2 list
                    return intersection
        
        return intersection 
    
    def binarySearch(self,target,nums2,start_idx):
        left = start_idx
        right = len(nums2)-1

        while left<=right:
            mid = left + (right-left)//2

            if nums2[mid]==target: # found target, check if it is leftmost?
                if mid==start_idx or nums2[mid-1]<nums2[mid]: # leftmost
                    return mid
                else:
                    right = mid-1 # search in left-half
            elif nums2[mid]>target: # target lies in left-half
                right = mid-1 
            else: # target lies in right-half
                left = mid+1
        
        return -1 # target not found