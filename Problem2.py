#Time complexity is:O(log(n1))
#Space complexity is:O(1)
#Code ran successfully on leet code
#No issues faced while coding

import sys
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if(len(nums1)==0 and len(nums2)==0):
            return 0.0
        #We are finding the lengths of the arrays and we will make sure that nums1 is less than nums2
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.findMedianSortedArrays(nums2,nums1)
        #Taking low and high pointers to perform partitions on smaller array
        low=0
        high=n1
        while(low<=high):
            #We will find partitons in both arrays based on belwo formulae
            partX=low+(high-low)/2
            partY=(n1+n2)/2-partX
            #If partX is 0, we will take minimum integer value as l1 otherwise nums1[partX-1]
            if(partX==0):
                l1=-1*(sys.maxint)
            else:
                l1=nums1[partX-1]
            #If partX is n1, we will take maximum integer value as r1 otherwise nums1[partX]
            if(partX==n1):
                r1=sys.maxint
            else:
                r1=nums1[partX]
            #If partY is 0, we will take minimum integer value as l2 otherwise nums2[partY-1]
            if(partY==0):
                l2=-1*(sys.maxint)
            else:
                l2=nums2[partY-1]
            #If partY is n2, we will take maximum integer value as r2 otherwise nums2[partY]
            if(partY==n2):
                r2=sys.maxint
            else:
                r2=nums2[partY]
            #Based on l1,l2,r1,r2 values we will find the median value
            if(l1<=r2 and l2<=r1):
                #correct partition
                if((n1+n2)%2==0):
                    return (max(l1,l2)+min(r1,r2))/2.0
                else:
                    return float(min(r1,r2))
            elif(l2>r1):
                low=partX+1
            else:
                high=partX-1
        #We are just returning some dummy value
        return 16.23

