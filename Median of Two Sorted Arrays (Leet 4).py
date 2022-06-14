# Time: log(m), list with less elements length
# Space: O(1)
# Executed Successfully: Yes

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        if len(nums1) == 0 and len(nums2) == 0:
            return 0
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        l = 0
        r = n1
        
        while l <= r:
            
            part_x = l + (r - l)//2
            part_y = ((n1 + n2)//2) - part_x
            
            l1 = float('-inf') if part_x == 0 else nums1[part_x - 1]
            r1 = float('inf') if part_x == n1 else nums1[part_x]
            
            l2 = float('-inf') if part_y == 0 else nums2[part_y - 1]
            r2 = float('inf') if part_y == n2 else nums2[part_y]
            
            if l1 <= r2 and l2 <= r1:
                # correct partition
                if (n1 + n2)%2 == 0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif l2 > r1:
                l = part_x + 1
            else:
                r = part_x - 1