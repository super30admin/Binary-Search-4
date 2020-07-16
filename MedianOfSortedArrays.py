--------------------------------Median of Two Arrays---------------------------------------------
# Time Complexity : O(log(m+n)) where m is length of nums1, n is length of nums2
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I Here I used a partition strategy where I will partition the two arrays into 2 sets where we can check the all left partition elements are
# smaller than the right partition elements and both partitions should have the same number of elements. One we get the correct partition
we will check the max element of nums1 (l1) and max element of nums2 (l2), min element of nums1 at right partition (r1) and min element of nums2 at right partition (r2).
# If our length of both arrays is odd then we can take the max of left side max elements else if our l2 greater than r1 then we have to move the l2 to smaller elements so we will move 
# our low to partX+1 else we will move high to partX-1.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1
            
        n1 = len(nums1)
        n2 = len(nums2)

        low = 0
        high = n1
        
        while low<=high:
            partX = (low+high)//2
            partY = ((n1+n2+1)//2)-partX
            
            l1 = nums1[partX-1] if partX != 0 else float('-inf')
            l2 = nums2[partY-1] if partY != 0 else float('-inf')
            r1 = nums1[partX] if partX != n1 else float('inf')
            r2 = nums2[partY] if partY != n2 else float('inf')
            
            if l1<=r2 and l2<=r1:
                if (n1+n2)%2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return max(l1,l2)
            elif l2>r1:
                low = partX+1
            else:
                high = partX-1  
        return -1
        