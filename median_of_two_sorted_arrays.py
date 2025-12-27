# https://leetcode.com/problems/median-of-two-sorted-arrays
# Time Complexity- O(log(min(m,n))) Space Complexity- O(1)

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # find the length of the arrays
        n1 = len(nums1)
        n2 = len(nums2)
        # we need to apply binary search on lower length array so find out which array is smaller
        if n1 > n2:
            # in this recursive function if the n1 is greater, swapping the arrays with reversed argument
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        
        while low <= high:
            # partition the array
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX

            # find the left and right elements from the partition
            # L1 and L2 represents the largest value from the left side  and R1, R2 represents the smallest value from the right side
            L1 = float('-inf') if partX == 0 else nums1[partX - 1]
            R1 = float('inf') if partX == n1 else nums1[partX]
            L2 = float('-inf') if partY == 0 else nums2[partY - 1]
            R2 = float('inf') if partY == n2 else nums2[partY]

            # this condition checks if the partition is valid
            # as the first and second array's left and right element is sorted so check with the opposite array
            if L1<= R2 and L2 <= R1:
                # if the combined array has even number
                if (n1 + n2) % 2 == 0:
                    # find the median by dividing the middle two elements
                    return (max(L1, L2) + min(R1, R2))/ 2
                else:
                    # if the combined array has odd number 
                    return min (R1, R2)
            # move the pointer
            elif L1 > R2:
                high = partX
            else:
                low = low + 1

        return -1
    
solution = Solution()
print(solution.findMedianSortedArrays([1,3],[2]))