# Time Complexity : O(log(m,n))
# Space Complexity : O(1)

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        if nums1 is None and nums2 is None:
            return -1.0
        
        m, n = len(nums1), len(nums2)
        if m > n:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low, high = 0, m
        
        while low <= high:
            partX = (low + high) // 2
            partY = (m + n) // 2 - partX
            
            l1 = float('-inf') if partX == 0 else nums1[partX - 1]
            l2 = float('-inf') if partY == 0 else nums2[partY - 1]
            
            r1 = float('inf') if partX == m else nums1[partX]
            r2 = float('inf') if partY == n else nums2[partY]
            
            if l1 <= r2 and l2 <= r1:
                if (m + n) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2.0
                else:
                    return min(r1, r2)
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1
        
        return -1.0

# Examples
solution = Solution()

# Example 1
nums1_1 = [1, 3]
nums2_1 = [2]
print("findMedianSortedArrays({}, {}) = {}".format(nums1_1, nums2_1, solution.findMedianSortedArrays(nums1_1, nums2_1)))  # Expected output: 2.0

# Example 2
nums1_2 = [1, 2]
nums2_2 = [3, 4]
print("findMedianSortedArrays({}, {}) = {}".format(nums1_2, nums2_2, solution.findMedianSortedArrays(nums1_2, nums2_2)))  # Expected output: 2.5

# Example 3
nums1_3 = [0, 0]
nums2_3 = [0, 0]
print("findMedianSortedArrays({}, {}) = {}".format(nums1_3, nums2_3, solution.findMedianSortedArrays(nums1_3, nums2_3)))  # Expected output: 0.0