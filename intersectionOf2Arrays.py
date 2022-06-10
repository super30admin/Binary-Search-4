'''
Solution: Assume that nums1 and nums2 are sorted
Time Complexity: len(nums1) = x and len(nums2) = y ---> 0(x log(y))
Space Complexity: None
Run on leet-code: Yes
'''
class Solution:
    
    def binarySearch(self,nums2,low,high,target):
        
        while low <= high:
            
            # find the mid
            mid = (high-low)//2 + low
            
            # case 1: we have a match with target
            if target == nums2[mid]:
                
                # chk the immediate indexes behind
                while mid-1 >= low and nums2[mid-1] == target:
                    mid = mid-1
            
                return mid
                
            # case 2: our target < nums2[mid]
            elif target < nums2[mid]:
                # target is on the lhs of the list
                high = mid-1
                continue
            
            # case 3: our target > nums2[mid]
            elif target > nums2[mid]:
                # target is on the rhs of the list
                low = mid+1
                continue
        
        # I got nothing :(
        return -1
            
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # return the intersectingList
        intersectingList = []
        
        # sort nums1 and nums2
        nums1.sort()
        nums2.sort()
        
        # chk the len of smaller nums and iterate
        if len(nums2) < len(nums1):
            nums1, nums2 = nums2, nums1
        
        # iterate the nums1 to get the target
        # initialize low and high
        low = 0
        high = len(nums2)-1
        for target in nums1:
            
            # perform binarySearch on nums2
            index = self.binarySearch(nums2,low,high,target)
            
            # chk index
            if index != -1:
                
                # you have got an intersecting index!!
                intersectingList.append(target)
                
                # update the low
                low = index + 1
        
        '''end of for loop'''
        
        # return the intersecting list
        # print("Intersecting list is:\t",intersectingList)
        return intersectingList