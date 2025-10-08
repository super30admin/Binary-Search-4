'''
Solution: binary search on partitions on smaller array
    - let, m = len(smaller array), n = len(larger array)
    - Binary search range: [0,m]
    - 'mid' represents where to partition on smaller array. 
    - part_y (partition on larger array) = (m+n)//2 - mid
    - we check
        - left_of_partion_nums1<=right_of_partion_nums2 and left_of_partion_nums2<=right_of_partion_nums1
            - perfect partition. 
            - median is 
                - middle element -> if (m+n) = odd
                    - middle element will lie in part_y, 
                    which is min(right_of_partion_nums1,right_of_partion_nums2) 
                    (max(left_of_partion_nums1,left_of_partion_nums2) + min(right_of_partion_nums1,right_of_partion_nums2))/2
                - average of middle 2 elements -> if (m+n) = even
                    - which is (max of left side + min of right side)/2
Time Complexity: O(log(m))
Space Complexity: O(1)
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2,nums1) # flip
        
        m = len(nums1)
        n = len(nums2)

        # binary-search space of partitions on nums1 
        left = 0
        right = m

        while left<=right:
            mid = left + (right-left)//2 # partition_x 
            part_y = (m+n)//2 - mid # partition_y

            left_of_partion_nums1 = nums1[mid-1] if mid>0 else -10**6-1 #-inf if partition is at 0
            right_of_partion_nums1 = nums1[mid] if mid<m else 10**6+1 # +inf if partition is end of array

            left_of_partion_nums2 = nums2[part_y-1] if part_y>0 else -10**6-1
            right_of_partion_nums2 = nums2[part_y] if part_y<n else 10**6+1
            
            if left_of_partion_nums1<=right_of_partion_nums2 and left_of_partion_nums2<=right_of_partion_nums1:
                # perfect, we got the right partition
                if (m+n)%2==0: # even
                    return (max(left_of_partion_nums1,left_of_partion_nums2) + min(right_of_partion_nums1,right_of_partion_nums2))/2
                else: # odd
                    return min(right_of_partion_nums1,right_of_partion_nums2)
            elif right_of_partion_nums1<left_of_partion_nums2:
                # move part_y to left --> move part_x to right --> do binary search on rightsubspace
                left = mid+1
            else: # do binary search on left sub-space
                right = mid-1
        
        return 2.000 # random, as system will exit above