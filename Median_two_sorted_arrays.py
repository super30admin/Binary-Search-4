// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we try to do binary serach on the array which is having less number of elements.we do binary search to find the partition in both the arrays such that we do same number of elements on both the sides of parition in case of eveen number of elements and one extra on the left side in case of odd number of elements.we try to change the partitions of both the arrays to make sure all the elements on the left side of the partition is less than all the elements on the right side of partition.when we find one that is where we can get the median of both the arrays.


# Time complexity : o(logm) m is the length of the array which has less number of elements
# space complexity : o(1)
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        
        if len(nums1)>len(nums2):
            x=nums2
            y=nums1
        else:
            x=nums1
            y=nums2
        m=len(x)
        n=len(y)
        low=0
        high=m
        while low<=high:
            partX=int((low+high)/2)
            partY=int((m+n+1)/2)-partX
            if partX==0:
                maxleftx=float('-inf')
            else:
                maxleftx=x[partX-1]
            if partX==m:
                minrightx=float('inf')
            else:
                minrightx=x[partX]
            if partY==0:
                maxlefty=float('-inf')
            else:
                maxlefty=y[partY-1]
            if partY==n:
                minrighty=float('inf')
            else:
                minrighty=y[partY]
            if maxleftx<=minrighty and maxlefty<=minrightx:
                if (m+n)%2==0:
                    return ((max(maxleftx,maxlefty)+min(minrighty,minrightx))/2.0)
                else:
                    return max(maxleftx,maxlefty)
            elif maxleftx>minrighty:
                high=partX-1
            else:
                low=partX+1
        return 0.0