'''
Time Complexity: 0(logn) --> n is the smallest length of the list
Space Complexity : None 
Run on LeetCode: Yes
'''
class Solution:
    
    def binarySearchPartition(self,nums1,nums2,low,high,total):
        
        # initlize x-partition and y-partition for nums1 and nums2 resp
        x_partition = None
        y_partition = None
        
        while low <= high:
            
            # cal mid
            mid = (high-low)//2 + low

            # mid is my x_partition
            x_partition = mid

            # get the y_partition
            '''
            formula 
            '''
            y_partition = (total//2) - x_partition

            # compare the elements and initlize the values

            # lhs_nums1             # rhs_nums1
            # lhs_nums2             # rhs_nums2
            
            # print('\n*********')
            lhs_nums1 = None
            if (x_partition-1) < 0:
                lhs_nums1 = float('-inf')
            else:
                lhs_nums1 = nums1[x_partition-1]
            # print("lhs_nums1",lhs_nums1)

            lhs_nums2 = None
            if (y_partition-1) < 0:
                lhs_nums2 = float('-inf')
            else:
                lhs_nums2 = nums2[y_partition-1]
            # print("lhs_nums2",lhs_nums1)
            
            rhs_nums1 = None
            if (x_partition) == len(nums1):
                rhs_nums1 = float('inf')
            else:
                rhs_nums1 = nums1[x_partition]
            # print("rhs_nums1",rhs_nums1)
            
            rhs_nums2 = None
            if (y_partition) == len(nums2):
                rhs_nums2 = float('inf')
            else:
                rhs_nums2 = nums2[y_partition]
            # print("rhs_nums2",rhs_nums2)
            
            # compare the conditions
            if lhs_nums1 <= rhs_nums2 and lhs_nums2 <= rhs_nums1:
                # OK condition i.e. without breech
                return (lhs_nums1,lhs_nums2,rhs_nums1,rhs_nums2)

            # we have a breech
            elif lhs_nums1 > rhs_nums2:
                # do-something
                high = mid - 1
                continue

            elif lhs_nums2 > rhs_nums1:
                # do-somthing
                low = mid + 1
                continue
    
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        # chk the length
        if len(nums2) < len(nums1):
            nums1, nums2 = nums2, nums1
        
        # partition index
        # for nums1 ---> 0 -- len(nums1)
        # for nums2 ---> 0 -- len(nums2)
        
        # totalElements
        total = len(nums1) + len(nums2)
        
        # initialize low and high ptrs for nums1 list
        low = 0
        high = len(nums1) 
        
        # perform binarySearch on the num1 list
        rtrTuple = self.binarySearchPartition(nums1,nums2,low,high,total)
        
        result = None
        if total%2 == 0:
            # we have even count 
            result = (max(rtrTuple[0],rtrTuple[1]) + min(rtrTuple[2],rtrTuple[3])) / 2
        else:
            # we have odd count
            result = min(rtrTuple[2],rtrTuple[3])
        
        # print("Median result is:\t",result)
        return result