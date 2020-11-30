class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        index = 0
        result = []
        
        def binarySearch(array, num, left, right):
            
            while left<=right:
                mid = (left+right)//2
                if array[mid]>num:
                    right = mid-1
                elif array[mid]<num:
                    left = mid+1
                elif array[mid] == num:
                    if mid == left or array[mid-1]<array[mid]:
                        return mid
                    else:
                        right = mid-1
            return -1
        for num in nums1:
            
            id = binarySearch(nums2, num, index, len(nums2)-1)

            if id!=-1:
                result.append(num)
                index=id+1
        
        return result
            
                
TIME: NLOGN + MLOGM + Nlogm
Space: O(m+n)