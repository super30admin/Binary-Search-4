# Time Complexity: O(min(n,m))
# Space Complexity: O(1)
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n = len(nums1)
        m = len(nums2)
        if n == 0 and m == 0:
            return 0
        if n > m:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n
        while low <= high:
            part_x = low + (high-low)/2
            part_y = (n+m)//2 - part_x
            l1 = -1
            if part_x == 0:
                l1 = -100000000007
            else:
                l1 = nums1[part_x-1]
            r1 = -1
            if part_x == n:
                r1 = 100000000007
            else:
                r1 = nums1[part_x]
            l2 = -1
            if part_y == 0:
                l2 = -100000000007
            else:
                l2 = nums2[part_y-1]
            r2 = -1
            if part_y == m:
                r2 = 100000000007
            else:
                r2 = nums2[part_y]
            if l1 <= r2 and l2 <= r1:
                if ((n+m)%2) == 1:
                    return min(r1, r2)
                else:
                    return (max(l1, l2)+min(r1, r2))/2.0
            elif l2 > r1:
                low = part_x + 1
            else:
                high = part_x - 1
                
        
                
            
            
