# TimeComplexity: O(log(min(m,n)))
# Space Complexity: Constant
# Approach:
# BruteForce :add both nums into single list and then sort
# Optimal:
# Find lengths ,and find min length array
#         assign low and high pointers for partition
#         find split such a way that both number of elements in both arrays combined will have same ele for 2 groups
#         x->small, y->large ..x split at x1 then y split will be at (n1+n2)//2 - x1 which is we get x1 ele from x 
#         now you got split we should check if its valid or not by  comparing  4 elements 
#         Think as moving partioton pointer ont x1
#edge case if partition is at either at start or end of nums .. assgin +inf if at the end ,-inf if at start







class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        Find lengths ,and find min length array
        assign low and high pointers for partition
        find split such a way that both # ele in both arrayscombined will have same ele for 2 groups
        x->small, y->large ..x split at x1 then y split will be at (n1+n2)//2 - x1 which is we get x1 ele from x 
        now you got split we should check if its valid or not by  comparing  4 elements 
        Think as moving partioton pointer ont x1  
        """
        n1,n2=len(nums1),len(nums2)
        
        if n1>n2:
            x1, y1 = nums2, nums1
            n1, n2 = n2, n1
        else:
            x1=nums1
            y1=nums2
        low,high=0,len(x1) #here high is not len-1 beacuse we have len+1 partitions 
        while(low<=high):
            
            mid=(low+high)//2
            ysplit= (n1+n2)//2 -mid
            #check for out of bounds
            # if mid==0 or mid ==len(x1)-1 :
            #     if mid==0:
            #x11, x12 , y11, y12
            if mid==0:
                x11=float('-inf')
                x12=float('inf') if len(x1) == 0 else x1[mid]
            elif mid==len(x1): 
                x12=float('inf')
                x11=x1[mid-1]
            else:
                x11=x1[mid-1]
                x12=x1[mid]
            1+2
            if ysplit ==0:
                y11=float('-inf')
                y12=y1[ysplit]
            elif ysplit==len(y1):
                y12=float('inf')
                y11=y1[ysplit-1]
            else:
                y11=y1[ysplit-1]
                y12=y1[ysplit]

                    
            print(x11,y11,x12,y12)
            if x11<=y12 and x12>=y11:
                #return based on odd or even
                if (n1+n2)%2==0:
                    print(x11,x12)
                    return (max(x11,y11)+min(x12,y12))/2
                else: return min(x12,y12)
            elif x11>y12:
                high=mid-1
            else:
                low=mid+1


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged_array = sorted(nums1+nums2)

        n = len(merged_array)
        if n%2 == 0:
            return (merged_array[n//2] + merged_array[n//2 -1]) / 2
        else:
            return merged_array[n//2]
