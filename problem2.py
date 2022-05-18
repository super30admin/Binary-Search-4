#Median of Two Sorted Arrays
# // Time Complexity :  O(log min(n,m))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
    if(len(nums1)>len(nums2)):
        nums1,nums2=nums2,nums1
    low=0
    high=len(nums1)
    
    while(low<=high):

        partx = (low+high)//2                                   #partition of first array
        party = (((len(nums1)+len(nums2))//2) - partx)          #partition of second
        l1 = float('-infinity') if (partx==0) else nums1[partx-1]               #set the values of left, right for each array

        l2 = float('-infinity') if (party==0) else nums2[party-1]
        r1 = float('infinity') if (partx==len(nums1)) else nums1[partx]
        r2 = float('infinity') if (party==len(nums2)) else nums2[party]

        if(l2>r1):                                              # shift the pointers based on the result you get
            low=partx+1
            
        elif (l1 > r2):
            high=partx-1

        else:

            if((len(nums1)+len(nums2)) %2 == 0):

                return (max(l1,l2) + min(r1,r2))/2              #if the length of arrays is odd, find the min of the left one and max of the right one and find average
            else:
                return min(r1,r2)                               #if its even, then return min of the right ones