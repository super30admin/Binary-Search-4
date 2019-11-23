# Leetcode - 4 - Median of two sorted arrays - https://leetcode.com/problems/median-of-two-sorted-arrays/
# Time compexity - min(O(log(N) ,o(logM)) which ever is smaller that we consider
# space complexity - O(1)
# Approach - we do binary search for the smaller array and divide the partions into two parts for both arrays. The condition should be L1<=R1 and R2 and L2<=R1 and R2.

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        
        n1=len(nums1)
        n2=len(nums2)
        
        low=0
        high=n1
        while low<=high:
            partx=low+(high-low)//2
            party=(n1+n2+1)//2 -partx # 1 to consider odd length
            L1=float("-inf") if partx == 0 else nums1[partx-1]
            R1=float("inf") if partx==n1 else nums1[partx]
            L2=float("-inf") if party==0 else nums2[party-1]
            R2=float("inf") if party==n2 else nums2[party]
            #base condition 
            if (L1<=R2 and L2<=R1):
                if (n1+n2)%2==0:
                    return (max(L1,L2)+min(R1,R2))/2.0
                else:
                    return max(L1,L2)
            elif L2>R1:
                low=partx+1
            else:
                high=partx-1
        return -1
            
            
            
            
