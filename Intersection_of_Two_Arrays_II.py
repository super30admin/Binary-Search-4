from collections import Counter

class Solution:
    
    #Hasmap_solution
    def intersect_h(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
        
        counter = Counter(nums2)
        result = []
        for i in range(len(nums1)):
            if nums1[i] in counter and counter[nums1[i]] > 0:
                result.append(nums1[i])
                counter[nums1[i]] -=1
        return result
    
    #Two_pointer
    def intersect_T(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
                
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
        
        result = []
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        n1 , n2 = len(nums1), len(nums2)
        p1, p2 = 0, 0
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 +=1
                p2 +=1
                
            elif nums1[p1] < nums2[p2]: 
                p1 +=1
                    
            else:
                p2 +=1
        
        return result
    
    #binary_search
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
                
        if len(nums1) > len(nums2):
            return self.intersect(nums2,nums1)
        
        result = []
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        n1 , n2 = len(nums1), len(nums2)
        low = 0
        for i in range(n1):
            index = self.binarysearch(nums2,nums1[i],low)
            if index is not -1 :
                result.append(nums1[i])
                low = index+1
            
        return result
    
    def binarysearch(self,nums2,x,low):
        
        low = low
        high = len(nums2)-1
        while low<= high:
            mid = low + (high-low)// 2
            if nums2[mid] == x:
                
                if (mid == low) or (nums2[mid-1] < nums2[mid]):
                    return mid
                else:
                    high = mid-1
                
            elif nums2[mid] > x:
                high = mid -1
            
            else:
                low = mid+1
        
        return -1
        
        
        
        
        
        
        
    
