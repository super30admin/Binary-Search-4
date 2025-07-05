# Approach:
# ----------
# 1. Use binary search on the smaller array to find a partition point.
# 2. The goal is to partition both arrays such that:
#    - Left parts of both arrays contain half of the total elements
#    - The maximum of the left parts ≤ minimum of the right parts
# 3. At each step:
#    - Let `midpoint` be the number of elements taken from A (smaller array)
#    - Then `mid - midpoint` will be the number taken from B
# 4. If Aleft > Bright → move left
#    If Bleft > Aright → move right
#    If both conditions satisfied → compute the median

# Time Complexity: O(log(min(n, m)))
# Space Complexity: O(1)

class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        A, B = nums1, nums2
        if len(A) > len(B):
            A, B = B, A
        mid = (len(A) + len(B)) // 2
        left = 0
        right = len(A)
        while left <= right:
            midpoint = (left+right)//2
            secondhalf = mid - midpoint
            Aleft = A[midpoint - 1] if midpoint > 0 else float('-inf')
            Aright = A[midpoint] if midpoint < len(A) else float('inf')
            Bleft = B[secondhalf - 1] if secondhalf > 0 else float('-inf')
            Bright = B[secondhalf] if secondhalf < len(B) else float('inf')
            if Aleft <= Bright and Bleft <= Aright:
                if (len(A)+len(B))%2 == 0:
                    first = max(Aleft, Bleft)
                    second = min(Aright, Bright)
                    return (first+second) / 2.0
                else:
                    return min(Aright, Bright)
            elif Aleft > Bright:
                right = midpoint - 1
            else:
                left = midpoint + 1
        return -1

def main():
    sol = Solution()

    # Odd total, interleaving elements
    print("Test Case 1: Odd Total")
    print("Median:", sol.findMedianSortedArrays([1, 3], [2]))  # Expected: 2.0

    # Even total, full interleave
    print("\nTest Case 2: Even Total")
    print("Median:", sol.findMedianSortedArrays([1, 2], [3, 4]))  # Expected: 2.5

    # All elements in one array smaller
    print("\nTest Case 3: All Left in One, All Right in Other")
    print("Median:", sol.findMedianSortedArrays([1, 2, 3], [100, 200, 300]))  # Expected: 51.5

    # Empty first array
    print("\nTest Case 4: First Array Empty")
    print("Median:", sol.findMedianSortedArrays([], [1, 2, 3, 4, 5]))  # Expected: 3.0

    # Empty second array
    print("\nTest Case 5: Second Array Empty")
    print("Median:", sol.findMedianSortedArrays([1, 2, 3, 4, 5], []))  # Expected: 3.0

    # Arrays of very different lengths
    print("\nTest Case 6: Unequal Lengths")
    print("Median:", sol.findMedianSortedArrays([1, 2], [3, 4, 5, 6, 7, 8, 9]))  # Expected: 5.0

    # Single element in each
    print("\nTest Case 7: Single Element Each")
    print("Median:", sol.findMedianSortedArrays([1], [2]))  # Expected: 1.5

    # Large elements
    print("\nTest Case 8: Large Values")
    print("Median:", sol.findMedianSortedArrays([1000000], [1000001]))  # Expected: 1000000.5

    # Duplicates
    print("\nTest Case 9: Many Duplicates")
    print("Median:", sol.findMedianSortedArrays([1, 1, 1], [1, 1, 1]))  # Expected: 1.0

    # Mix of negative and positive
    print("\nTest Case 10: Negative and Positive")
    print("Median:", sol.findMedianSortedArrays([-5, 3, 6], [-2, 4, 10]))  # Expected: 3.5

if __name__ == "__main__":
    main()