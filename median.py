# // Time Complexity :O(log(n1))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we do binary search on shorter arrays partitions and partition the two arrays such that elements on left and right of combined array will have same elems.
# our partition is successful if all elems in left is smaller than all elems n right. if not - we redo the partition accordingly. 
# if yes - we return the min(R1,R2) the right elemnt of partition in case of odd number of elements. in case of even num of elems- we take average of elem on left adn right of partition
import math
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if not nums1 and not nums2:
            return 0
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.findMedianSortedArrays(nums2, nums1)
        low=0
        high=n1
        while(low<=high):
            partx=(low+ high)//2
            party=(n1+n2)//2 - partx
            if partx==0:
                l1=float('-inf')
            else:
                l1=nums1[partx-1]
            if party==0:
                l2=float('-inf')
            else:
                l2=nums2[party-1]
            if partx==n1:
                R1=float('inf')
            else:
                R1=nums1[partx]
            if party==n2:
                R2=float('inf')
            else:
                R2=nums2[party]
            if(l1<=R2 and l2<=R1):
                # good
                if((n1+n2)%2==0):
                    # even
                    return ((max(l1,l2) + min(R1,R2))/2.0)
                else:
                    return min(R1,R2)
            elif(l2>R1):
                low=partx+1
            else:
                high=partx-1
        return 0