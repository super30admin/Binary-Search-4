# Time Comelexity: O(log(min(m,n)))
# Space Complexity: In Place - O(1)
# Approach: Try to find a partition such that every element in the left half of the partition is less than every element on the right half for both the arrays.
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # Always perform binary search on smaller of two arrays
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
    
        # Initialize pointers
        start_X = 0
        end_X = len(nums1)
        x = len(nums1)
        y = len(nums2)
        partition_X = 0
        partition_Y = 0
        
        while start_X <= end_X:
            # partition_X divides the array nums1 in half
            partition_X = (start_X + end_X) / 2
            
            # partition_2 divides the array nums2 such that the combined number of elements in nums1:partition_x + nums2:partition_y is equal to the number of elements partition_x:end(nums1) + partition_y:end(nums2)
            partition_Y = ((x + y + 1) / 2) - partition_X
            
            # Max number on left side of partition - nums1
            maxLeftX = nums1[partition_X - 1] if partition_X != 0 else float('-inf')
            # Min number on right side of partition - nums1
            minRightX = nums1[partition_X] if partition_X != x else float('inf')
            
            # Max number on left side of partition - nums2
            maxLeftY = nums2[partition_Y - 1] if partition_Y != 0 else float('-inf')
            # Min number on right side of partition - nums2
            minRightY = nums2[partition_Y] if partition_Y != y else float('inf')
            
            # If this condition is true, partition is found
            if maxLeftX <= minRightY and minRightX >= maxLeftY:
                # Even number of elements - take average of mid elements
                if (x + y) % 2 == 0:
                    return (max(maxLeftX,maxLeftY) + min(minRightX,minRightY)) / 2.0
                # Odd number of elements - max of left partition elements
                else:
                    return max(maxLeftX,maxLeftY)
            # Move search to left
            elif maxLeftX > minRightY:
                end_X = partition_X - 1
            else: # Move search to right
                start_X = partition_X + 1
                