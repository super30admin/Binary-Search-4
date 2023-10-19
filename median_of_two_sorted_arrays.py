# Time Complexity: O(log(m+n)) where m and n is length of lists
#  Space Complexity:  O(1).
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No



class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len_nums1 = len(nums1)
        len_nums2 = len(nums2)
        # to make the smaller length array at the beginning. # Binary Search on smaller array.
        if(len_nums2 < len_nums1):
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = len_nums1

        while (low <= high):
            part_x = (low + high) // 2
            part_y = (len_nums1+ len_nums2) // 2 - part_x

            l1 = float("-inf") if part_x == 0 else nums1[part_x-1]
            l2 = float("-inf") if part_y == 0 else nums2[part_y-1]
            r1 = float("inf") if part_x == len_nums1 else nums1[part_x]
            r2 = float("inf") if part_y == len_nums2 else nums2[part_y]

            if(l1 <= r2 and l2 <= r1):
                if((len_nums1 + len_nums2) % 2 == 0 ):
                    return (max(l1,l2) + min(r1,r2)) / 2 
                return min(r1,r2)
            
            if (l2 > r1):
                low = part_x + 1
                
            elif l1 > r2:
                high = part_x-1
        
        return 0
