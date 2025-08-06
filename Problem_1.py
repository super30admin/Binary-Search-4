'''
350 Intersection of Two Arrays II
https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Solution:
1. Linear Search
For every element in array 1, search for the corresponding element in array 2.
If an element is found in array 2, don't use that element in the next search by marking it as INT_MAX or INT_MIN.
Let M = len(array1), N = len(array2)
https://youtu.be/2nGcMdebMvU?t=172
Time: O(MN), Space: O(1)

2. Hash Map:
Store the elements of the smaller array (array 1 of len M) in a hash map with key = element and value = frequency of element in array 1. Now traverse the larger array (array 2 of len N). If any element of array 2 exists in the hash map, then that element is an element common/intersecting b/w the two arrays.

a) For the intersecting element, reduce freq of count by 1. If the count falls to 0, then delete that element from the map. For eg. if array 1 has two 4's and array 2 has three 4's, there are only two 4's which are intersecting. As soon as we encounter the second 4 in array 2, we delete 4 from the hash map as it automatically becomes a non-intersecting element.
b) For any non-intersecting element, don't add it to the hash map.

The result is all the intersecting elements that we found in a).
https://youtu.be/2nGcMdebMvU?t=355
Time: O(M+N), Space: O(min(M,N)) = O(M)

3. Two pointer:
Sort the two arrays. Initialize the two pointers (p1, p2) to point to 0 index of both arrays. Advance each pointer by 1. Three possibilities:
a) If arr[p1] == arr[p2], then we found an intersecting element. Advance p1, p2 by 1
b) If arr[p1] < arr[p2], then p1 points to the smaller element. Advance p1
c) If arr[p1] > arr[p2], then p2 points to the smaller element. Advance p2
We continue traversing until any one of the pointer goes out of bounds.
https://youtu.be/2nGcMdebMvU?t=801
Time: O(M log M + N log N + M + N) = O(M log M + N log N), Space: O(1)

4. Binary search:
Sort the two arrays. We get the target element from the smaller array and perform a binary search to find the first occurrence of the target in the larger array from (0 to N-1). If we find the target in the larger array, we get the index (bsid) of the larger array. Then, for the next binary search on a new target, we do the search in the larger array in a contracted space (bsid, N-1) but not the entire space (0, N-1). If we use the entire space, we might end up incorrectly repeating the target too many times.
Eg:
arr1 = [4,4,4,5,9,9] (M=6)
arr2 = [4,4,4,4,5,5,8,9] (N=8)

Binary search in the contracted space
bsid = bs(arr1[0]=4, 0, 7, arr2) # bsid = 0, result = [4]
bsid = bs(arr1[1]=4, 1, 7, arr2) # bsid = 1, result = [4,4]
bsid = bs(arr1[2]=4, 2, 7, arr2) # bsid = 2, result = [4,4,4]
bsid = bs(arr1[3]=5, 3, 7, arr2) # bsid = 4 (not 3), result = [4,4,4,5]
bsid = bs(arr1[4]=9, 5, 7, arr2) # bsid = 7, result = [4,4,4,5,9]
bsid = bs(arr1[5]=9, 8, 7, arr2) # bsid = -1, result = [4,4,4,5,9] (correct)

Binary search in the entire space
bsid = bs(arr1[0]=4, 0, 7, arr2) # bsid = 0, result = [4]
bsid = bs(arr1[1]=4, 0, 7, arr2) # bsid = 0, result = [4,4]
bsid = bs(arr1[2]=4, 0, 7, arr2) # bsid = 0, result = [4,4,4]
bsid = bs(arr1[3]=5, 0, 7, arr2) # bsid = 4, result = [4,4,4,5]
bsid = bs(arr1[4]=9, 0, 7, arr2) # bsid = 7, result = [4,4,4,5,9]
bsid = bs(arr1[5]=9, 8, 7, arr2) # bsid = 7, result = [4,4,4,5,9,9] (incorrect)

https://youtu.be/2nGcMdebMvU?t=1864
Time: O(M log M + N log N + M log N) , Space: O(1)

'''

from collections import defaultdict

def intersect_2(nums1, nums2):
    ''' Hash map solution
        Time: O(M+N), Space: O(min(M,N)) = O(M)
    '''
    if not nums1 or not nums2:
        return []

    M = len(nums1)
    N = len(nums2)

    # use the smaller array as the first array
    # Why? To reduce space complexity of hash map
    if M > N:
        intersect_2(nums2, nums1)

    result = []
    h = defaultdict(int)
    for num in nums1:
        h[num] += 1

    for num in nums2:
        if num in h:
            result.append(num)
            h[num] -= 1
            if h[num] == 0:
                del h[num]
    return result

def intersect_3(nums1, nums2):
    ''' Two pointer solution
        Time: O(M log M + N log N + M + N) = O(M log M + N log N), Space: O(1)
    '''
    if not nums1 or not nums2:
        return []

    M = len(nums1)
    N = len(nums2)

    result = []
    nums1 = sorted(nums1.copy())
    nums2 = sorted(nums2.copy())
    p1, p2 = 0, 0
    while p1 < M and p2 < N:
        if nums1[p1] == nums2[p2]:
            result.append(nums1[p1])
            p1 += 1
            p2 += 1
        elif nums1[p1] < nums2[p2]:
            p1 += 1
        else:
            p2 += 1
    return result

def intersect_4(nums1, nums2):
    ''' Binary search solution
        Time: O(M log M + N log N + M log N) , Space: O(1)
    '''
    def binary_search(target, low, high, arr):
        if not arr:
            return -1

        while low <= high:
            mid = low + (high-low)//2
            if arr[mid] == target:
                if mid != low and arr[mid] == arr[mid-1]:
                    high = mid - 1 # move left to get first occurence of target
                else: # mid == low or arr[mid] != arr[mid-1]
                    return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    if not nums1 or not nums2:
        return []

    M = len(nums1)
    N = len(nums2)

    # use the smaller array as the first array
    # and perform binary search on the second array (larger)
    if M > N:
        intersect_4(nums2, nums1)

    result = []
    nums1 = sorted(nums1.copy())
    nums2 = sorted(nums2.copy())
    low, high = 0, N-1
    for i in range(M):
        index = binary_search(nums1[i], low, high, nums2)
        if index != -1:
            result.append(nums1[i])
            low = index + 1
    return result

def run_intersect():
    tests = [([4,9,5], [9,4,9,8,4], [4,9]),
             ([1,2,2,1], [2,2], [2,2]),
             ([4,4,4,5,9,9], [4,4,4,4,5,5,8,9], [4,4,4,5,9],)
    ]
    for test in tests:
        nums1, nums2, ans = test[0], test[1], test[2]
        print(f"\nnums1 = {nums1}")
        print(f"nums2 = {nums2}")
        for method in [2,3,4]:
            if method == 2:
                result = intersect_2(nums1, nums2)
            elif method == 3:
                result = intersect_3(nums1, nums2)
            elif method == 4:
                result = intersect_4(nums1, nums2)
            print(f"Method {method}: intersecting elements = {result}")
            success = (sorted(ans) == sorted(result))
            print(f"Pass: {success}")
            if not success:
                return

run_intersect()