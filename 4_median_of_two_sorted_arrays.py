'''

## Problem 4: Median of two sorted arrays.

## Author: Neha Doiphode
## Date:   06-11-2022

## Description:
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).

## Examples:
    Example 1:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.

    Example 2:
        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

## Constraints:
    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

'''

from typing import List, Optional

def get_input():
    print("Enter the array 1 of integers(with spaces): ", end = "")
    inp = input()
    inp1 = [int(val) for val in inp.split()]

    print("Enter the array 2 of integers(with spaces): ", end = "")
    inp = input()
    inp2 = [int(val) for val in inp.split()]

    return inp1, inp2

class Solution:
    def findMedianSortedArrays_two_pointers(self, nums1: List[int], nums2: List[int]) -> float:
        '''
        Time complexity : O(m + n) where m is length of array 1 and n is length of array 2.
        Space complexity: O(m + n) as we create a new auxiliary array of length m + n.
        '''
        ptr1 = ptr2 = 0

        combined = []
        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1] < nums2[ptr2]:
                combined.append(nums1[ptr1])
                ptr1 += 1

            else:
                combined.append(nums2[ptr2])
                ptr2 += 1

        if ptr1 < len(nums1):
            combined.extend(nums1[ptr1:])
        elif ptr2 < len(nums2):
            combined.extend(nums2[ptr2:])

        n = len(combined)
        mid = (n-1) // 2

        if n % 2 == 0:
            return (combined[mid] + combined[mid + 1]) / 2
        else:
            return combined[mid]

    def findMedianSortedArrays_binary_search(self, nums1: List[int], nums2: List[int]) -> float:
        '''
        Approach:     Partitions 0  1  2  3   4   5
                        Array 1: | 1| 4| 6| 7 | 10|     m = 5

                      Partitions 0  1  2  3   4   5
                        Array 2: | 3| 5| 8| 11| 13|     n = 5


                      Step 1: Check which is smaller array. In this case they are of equal length so we start from Array 1.
                              partX = mid = 0 + (5 - 0) // 2 = 2
                              Lets call this partition of length 2 as L1.

                      Step 2: Now, find out how many elements we need from Array 2 to form equal length left and right partitions.
                              partY = ( len(combined array) // 2 ) - partX
                                    = (10 // 2) - 2 = 3

                              So, if we take 2 elements(partX) from array 1 we will need 3 more elements from array2 so that we will have 5 elements in total on R1.
                              We need 5 elements total as in all we have 10 elements so divide the whole array equally we need to have 5 elements in a partition.

                      Step 3:
                                L1 = 1, 4       R1 = 6, 7, 10
                                L2 = 3, 5, 8    R2 = 11, 13

                      Step 4: We need to make sure that following conditions are satisfied:
                                * L1 <= R1 ------> We don't need to explicitly check this as the arrays are already sorted, L1 will always be smaller than R1.
                                * L1 <= R2
                                * L2 <= R1
                                * L2 <= R2 ------> We don't need to explicitly check this as the arrays are already sorted, L2 will always be smaller than R2.

                                So, we only care about:
                                        * L1 <= R2 and L2 <= R1

                      Step 5: In above case, L1 <= R2 is satisfied but L2 <= R1 is not satisfied as L2 contains larger elements than R1.
                              In order to get larger elements on R1, we need to recompute the partition of array 1.
                              To do so we change our low and high and repeat steps from 1 to 4 until condition mentioned in step 4 is satisfied.

                              current: low = 0                     and high = 5
                              new    : low = partX + 1 = 2 + 1 = 3 and high = 5 stays as is as we are moving low to the right side.

                              Now we need to repeat process from step1 to step 4.

                      Step 6: After iterations when L1 <= R2 and L2 <= R1 condition is satisfied,
                              1. For even length total array length
                                    max(L1, L2) + min(R1, R2) // 2

                              2. For odd length total array length
                                    Check the side which has more elements.
                                    If right side has more elements, median would be min(R1, R2) Ideally answer should always lie in R1.
                                    If left side has more elements, median would be max(L1, L2)

                      IMPORTANT:
                            * In case, if no elements are left in L1 or L2, we need to consider it as -INF.
                            * In case, if no elements are left in R1 or R2, we need to consider it as +INF.

        Time complexity : O(log N), where N is min(m,n), as we only perform binary search on a smaller array.
        Space complexity: O(1), as we don't use any auxiliary space.

        '''
        if len(nums1) == 0 and len(nums2) == 0:
            return 0.0

        m = len(nums1)
        n = len(nums2)

        if n < m:
            return self.findMedianSortedArrays_binary_search(nums2, nums1)

        low = 0
        high = m # since we are considering partition we are going to consider last partition number same as length of the array.

        while low <= high:
            # compute mid
            partX = low + (high - low) // 2  # length of partition X.
            partY = (m + n) // 2 - partX     # Total array length. Find mid of total. Subtract already chosen elements from partX.

            # now compute partition elements
            l1 = -float("inf") if partX == 0 else nums1[partX - 1]
            l2 = -float("inf") if partY == 0 else nums2[partY - 1]

            r1 = float("inf") if partX == m else nums1[partX]
            r2 = float("inf") if partY == n else nums2[partY]

            if l1 <= r2 and l2 <= r1:
                # if above condition is satisfied, check if the combined array is even length or odd length to calculate the median.
                # If array is even length:
                if (m + n) % 2 == 0:
                    # Answer lies on the
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)

            elif l1 > r2:
                # Move left, we need to recompute high
                high = partX - 1

            elif l2 > r1:
                # Move right
                low = partX + 1


        return 0.0

# Driver code
solution = Solution()
inp1, inp2 = get_input()
print("Input arrays are: ")
print(f"Array 1: {inp1}")
print(f"Array 2: {inp2}")
print(f"Approach 1: With two pointers : Median of two arrays: {solution.findMedianSortedArrays_two_pointers(inp1, inp2)}")
print(f"Approach 2: With binary search: Median of two arrays: {solution.findMedianSortedArrays_binary_search(inp1, inp2)}")
