# Time Complexity : O(m log n)
# Space Complexity : O(1)
# Binary Search Approach
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if(len(nums2) < len(nums1)):
            self.intersect(nums2, nums1)
            
        result = []
        nums1.sort()
        nums2.sort()
        
        
        print(nums1, nums2)
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        low = 0 
        for i in range(n1):
            bindex = self.binarysearch(nums2, low, n2-1, nums1[i])
            
            if(bindex != -1):
                result.append(nums1[i])
                low = bindex + 1
        return result
        
    def binarysearch(self, arr, low, high, target):
        while(low <= high):
            mid = low + int((high - low)/2)

            if(arr[mid] == target):
                # find the leftmost target
                if(mid == low or arr[mid] > arr[mid-1]):
                    return mid
                else:
                    high = mid - 1
            elif(arr[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        
        return -1