# Time Complexity :if two arrays sorted average O(logmin(n,m))
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # no of elements in nums1
        n1 = len(nums1)
        #no of elements in nums2
        n2 = len(nums2)
        #make sure you make binary search on longer array
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        # total number of elements before the median
        number = (n1+n2+1)/2
        # low and high for binarys earch
        low = 0
        high = n1
        while low <= high:
            # get mid
            mid = low + (high-low)/2
            #know position of partition in the second array
            partition2 = number - mid
            #get one number before and one number after the partition in both arrays
            l1 = float('-inf') if mid == 0 else nums1[mid-1]
            r1 = float('inf') if mid  == n1 else nums1[mid]
            l2 = float('-inf') if partition2 == 0 else nums2[partition2-1]
            r2 = float('inf') if partition2  == n2 else nums2[partition2]
            # if the partition is right
            if l1 <= r2 and l2 <=r1:
                # if sum of both arrays length is even
                if (n1+n2)%2 == 0:
                    # get max of left and min of right and add it then devide by two
                    return (max(l1,l2) + min(r1,r2)) / 2.0
                else:
                    # else return max of left
                    return max(l1,l2)
            # if the cut needs to move right
            elif l2 > r1:
                low = mid+1
            #else move the cut left
            else:
                high = mid -1
        return -1