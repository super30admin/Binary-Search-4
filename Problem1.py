#Leetcode 350: Intersection of two Arrays 2
# Time - nlogm
# space - o(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        result = []
        
        nums1.sort()
        nums2.sort()
        
        def binarySearch(arr, target, start, end):
            
            while(start <= end):
                
                mid = start + (end - start)//2
                
                if arr[mid] == target:
                    
                    if mid == start or arr[mid-1] != arr[mid]:
                        return mid
                    else:
                        end = mid - 1
                
                if target > arr[mid]:
                    start = mid + 1
                else:
                    end = mid - 1
            
            return -1
        
        start = 0
        end = len(nums2) - 1
        
        if len(nums1) > len(nums2):
            self.intersect(nums2,nums1)
            
        for num in nums1:
            
            index = binarySearch(nums2, num, start, end)
            
            if(index != -1):
                
                result.append(nums2[index])
                start = index + 1
            
                
        return result