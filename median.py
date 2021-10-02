# // Time Complexity :O(n1logn1),n1 smallest 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)==0 and len(nums2)==0: return 0.0
        # if len(nums1)==1 and len(nums2)==1: return (nums1[0]+nums2[0])/2
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        low=0
        high=len(nums1)
        while(low<=high):
            
            mid_1=(low+high)//2
            mid_2=((len(nums1)+len(nums2))//2 )-mid_1
            print(mid_1)
            print(mid_2)
            if mid_1 is not 0:
                l1=nums1[mid_1-1]
            else:
                l1=-inf
            if mid_1 is not len(nums1):
                r1=nums1[mid_1]
            else:
                r1=inf
        
            if mid_2 is not 0:
                l2=nums2[mid_2-1]
            else:
                l2=-inf
            if mid_2 is not len(nums2):
                r2=nums2[mid_2]
            else:
                r2=inf
            print(mid_1,mid_2)
            print(l1,l2,r1,r2)
            if l1<=r2 and l2<=r1:
                
                if(len(nums1)+len(nums2))%2 is not 0:
                    return min(r1,r2)
                else:
                    return (min(r1,r2)+max(l1,l2))/2
                
            elif l1>r2:
                
                high=mid_1-1
            else:
            
                low=mid_1+1
                
            print(low)
            print(high)
            
        