# Time Complexity : O(log(min(m,n)))
# Space Complexity : O(1)

# Approach:
# We try to partition the two arrays into two halves such that:
# 1. The left half contains the smaller elements and the right half contains the larger elements, when both arrays are combined.
# 2. The left half of the combined array contains the same number of elements as the right half, or one more element if the total number of elements is odd.
# 3. The maximum element of the left half is less than or equal to the minimum element of the right half.
# 4. If the total number of elements is even, the median is the average of the maximum element of the left half and the minimum element of the right half.
# 5. If the total number of elements is odd, the median is the minimum element of the right half.
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        # Ensure nums1 is the smaller array
        if len(nums1) > len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
        # Initialize the lengths of both arrays
        n1, n2 = len(nums1), len(nums2)
        # Initialize the binary search boundaries
        l, h = 0, n1

        # Perform binary search on the smaller array
        while l <= h:
            # Calculate the partition indices for both arrays
            partX = l + (h-l)//2
            partY = (n1+n2)//2 - partX

            # Calculate the maximum and minimum elements on both sides of the partitions
            # L1 and R1 are the maximum and minimum elements on the left and right sides of the partition in nums1
            L1 = nums1[partX-1] if partX > 0 else float("-inf")
            R1 = nums1[partX] if partX < n1 else float("inf")     
            # L2 and R2 are the maximum and minimum elements on the left and right sides of the partition in nums2
            L2 = nums2[partY-1] if partY > 0 else float("-inf")
            R2 = nums2[partY] if partY < n2 else float("inf")
         
            # Check if we have found the correct partition
            if L1 <= R2 and L2 <= R1:
                # If the total number of elements is even, return the average of the maximum element of the left half and the minimum element of the right half
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                # If the total number of elements is odd, return the minimum element of the right half
                else:
                    return min(R1, R2)
            # If the partition is not correct, adjust the binary search boundaries
            # If L1 > R2, move the partition in nums1 to the left
            elif L1 > R2:
                h = partX - 1
            # If L2 > R1, move the partition in nums1 to the right
            else:
                l = partX + 1

# Time Complexity : O(m+n)
# Space Complexity : O(m+n)

# Approach:
# 1. Merge the two sorted arrays into one sorted array by comparing the elements of both arrays.
# 2. Use two pointers to traverse both arrays and append the smaller element to the merged array.
# 3. Continue until one of the pointers reaches the end of its array.
# 4. If one array is exhausted, append the remaining elements of the other array to the merged array.
# 5. Calculate the median based on the length of the merged array.
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        # Initialize an empty result list
        res = []
        # Initialize two pointers for both arrays
        p1, p2 = 0, 0

        # Traverse both arrays until one of the pointers reaches the end of its array
        while p1 < len(nums1) and p2 < len(nums2):
            # Append the smaller element to the result and move the pointer
            if nums1[p1] <= nums2[p2]:
                res.append(nums1[p1])
                p1 += 1
            else:
                res.append(nums2[p2])
                p2 += 1
        # Append the remaining elements of the other array to the result
        while p1 < len(nums1):
            res.append(nums1[p1])
            p1 += 1
        while p2 < len(nums2):
            res.append(nums2[p2])
            p2 += 1
        # Get the length of the merged array
        n = len(res)
        # If the length is even, return the average of the two middle elements
        if n % 2 == 0:
            return (res[n//2-1] + res[n//2]) / 2
        # If the length is odd, return the middle element
        else:
            return res[n//2]