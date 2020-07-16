# Median of two arrays

# brute force method
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
		# combine the two arrays. Sort them and find the median
        # O(nlogn) time complexity | O(n+m) space complexity
        nums = nums1 + nums2
        nums = sorted(nums) # optionally can use 2 ptrs to merge them
        n = len(nums)
        
        if n%2==0:
            return (nums[n//2 - 1] + nums[n//2])/2
        return nums[n//2]

# partition approach
# O(log(m+n)) time complexity
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
    	n1, n2 = len(nums1), len(nums2)
        if n1==0:
            return nums2[n2//2] if n2%2!=0 else (nums2[n2//2 - 1] + nums2[n2//2])/2
        if n2==0:
            return nums1[n1//2] if n1%2!=0 else (nums1[n1//2 - 1] + nums1[n1//2])/2
            
        low, high = 0, n1
        
        while low <= high:
            partitionX = low + (high-low)//2
            partitionY = (n1+n2+1)//2 - partitionX
            L1 = float('-inf') if partitionX==0 else nums1[partitionX-1]
            R1 = float('inf') if partitionX==n1 else nums1[partitionX]
            L2 = float('-inf') if partitionY==0 else nums2[partitionY-1]
            R2 = float('inf') if partitionY==n2 else nums2[partitionY]
            
            if (L1 <= R2 and L2 <= R1):
                if (n1+n2)%2 != 0:
                    return max(L1, L2)
                else:
                    return (min(R1, R2) + max(L1, L2)) / 2
            elif L2 > R1:
                low += 1
            else:
                high -= 1