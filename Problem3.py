"""
// Time Complexity : o(logn), n - len of smaller list 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        l = 0
        h = n1
        
        while l <= h: #binary search on nums1
            part_x = l + (h - l) / 2 #find partition in nums1 and calculate partition in nums2
            
            part_y = (n1 + n2 + 1)/2 - (part_x)
            
            l1 = -sys.maxint - 1 if part_x == 0 else nums1[part_x - 1] 
            l2 = -sys.maxint - 1 if part_y == 0 else nums2[part_y - 1]
            
            r1 = sys.maxint if part_x == n1 else nums1[part_x]
            r2 = sys.maxint if part_y == n2 else nums2[part_y]
            
            if l1 <= r2 and l2 <= r1:
                #correct partition
                if (n1 + n2) % 2 == 0: #even case
                    return float(max(l1,l2) + min(r1,r2))/2
                else:
                    return max(l1,l2) #odd case
                
            elif l2 > r1:
                l = part_x + 1
            else:
                h = part_x - 1
                
        return -1