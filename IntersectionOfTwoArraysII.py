# Time Complexity : O(max(mlogm, nlogn))
# Space Complexity : O(m+n)

class Solution:
    def intersect(self, nums1, nums2):
        if not nums1 or not nums2:
            return []
        
        nums1.sort()
        nums2.sort()
        
        i, j = 0, 0
        result = []
        
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                result.append(nums1[i])
                i += 1
                j += 1
        
        return result

# Examples
solution = Solution()

# Example 1
nums1_1 = [1, 2, 2, 1]
nums2_1 = [2, 2]
print("intersect({}, {}) = {}".format(nums1_1, nums2_1, solution.intersect(nums1_1, nums2_1)))  # Expected output: [2, 2]

# Example 2
nums1_2 = [4, 9, 5]
nums2_2 = [9, 4, 9, 8, 4]
print("intersect({}, {}) = {}".format(nums1_2, nums2_2, solution.intersect(nums1_2, nums2_2)))  # Expected output: [4, 9]

# Example 3
nums1_3 = [1, 2, 2, 1]
nums2_3 = [2]
print("intersect({}, {}) = {}".format(nums1_3, nums2_3, solution.intersect(nums1_3, nums2_3)))  # Expected output: [2]