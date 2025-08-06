'''
4 Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

Solution:
1. Brute Force
We first merge both sorted arrays into one using two pointers. Then we find the middle index (or two middles if length is even). Finally, we return the median based on total length being odd or even.
Time: O(M+N), Space: O(M+N)

2. Binary Search
Let the smaller and the larger arrays be arr1 and arr2. We do a binary search on the smaller array to partition both arrays correctly. Let:
L1 = left partition of arr1
R1 = right partition of arr1
L2 = left partition of arr2
R2 = right partition of arr2

Partition numbering is different from index of the array:
Eg. If array is = 7  12  14  15, then

index        0       1       2       3
array        7       12      14      15
partition 0     1         2       3       4

Thus, if part = 1 (partition index), then
left partition  = arr[0:part] = [7]
right partition = arr[part:] = [12,14,15]

if part = 0 (partition index), then
left partition  = [- infinity]
right partition = arr[part:] = [7,12,14,15]

if part = 4 (partition index), then
left partition  = arr[0:part] = [7,12,14,15]
right partition = [+ infinity]

To get the median, we must partition the two arrays correctly. There is only one way to correctly partition the two arrays which we find by the binary search method. During the binary search, we search for the right partition indices of arr1 and arr2 by checking the following conditions:
max(L1) >= min(R1) (automatically satisfied since L1-R1 are generated from arr1)
max(L2) >= min(R2) (automatically satisfied since L2-R2 are generated from arr1)
max(L1) <= min(R2)
max(L2) <= min(R1)

If the conditions are satisfied, then the median is
Total length M+N is even: (max( max(L1), max(L2) ) + min (min(R1), min(R2)))/2
Total length M+N is odd: (max(max(L1),max(L2))  (left partition has 1 element more than right partition)

https://www.youtube.com/watch?v=HYUIYzr1Hv0
Time: O(log min(M,N)), Space: O(1)

'''
def findMedianSortedArrays(nums1, nums2):
    ''' Time: O(log min(M,N)), Space: O(1) '''
    M = len(nums1)
    N = len(nums2)
    if M > N:
        return findMedianSortedArrays(nums2, nums1)

    partition_size = (M + N + 1)//2
    # low = index of partition s.t. left of low contains all elements in the left partition
    # high = index of partition s.t. high and right of high contains all elements in the right partition
    # Using binary search, we converge low and high to find a common partition point
    low = 0
    high = M # Note: it's not M-1 because the last partition index is M! (a quirk of this problem)
    while low <= high: # O(log M)
        m1 = low + (high - low)//2
        m2 =  partition_size - m1

        # max ele on left partition of nums1
        l1 = float('-inf') if m1 == 0 else nums1[m1-1]
        # min ele on right partition of nums1
        r1 = float('+inf') if m1 == M else nums1[m1]
        # max ele on left partition of nums2
        l2 = float('-inf') if m2 == 0 else nums2[m2-1]
        # min ele on right partition of nums2
        r2 = float('+inf') if m2 == N else nums2[m2]

        if l1 <= r2 and l2 <= r1:
            if  (M + N) % 2 == 0:
                median = (max(l1,l2) + min(r1,r2))/2
            else:
                median = max(l1,l2)
            return median
        elif l1 > r2:
            high = m1 - 1
        elif l2 > r1:
            low = m1 + 1
    return float('inf') # median = dummy invalid no.

def run_findMedianSortedArrays():
    tests = [([7,12,14,15], [1,2,3,4,9,11], 8),
             ([1,3,4,7,10,12], [2,3,6,15], 5),
             ([1,3],[2],2),
             ([1,2],[3,4], 2.5),
    ]
    for test in tests:
        nums1, nums2, ans = test[0], test[1], test[2]
        median = findMedianSortedArrays(nums1,nums2)
        success = (ans == median)
        print(f"\nnums1 = {nums1}")
        print(f"nums2 = {nums2}")
        print(f"median = {median}")
        print(f"Pass: {success}")
        if not success:
            return

run_findMedianSortedArrays()
