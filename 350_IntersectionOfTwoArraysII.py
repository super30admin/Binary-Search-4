"""
Leetcode-https://leetcode.com/problems/intersection-of-two-arrays-ii/
TC O(m+n) SC- O(min(m, n))
ChallengesBinary search solution
Lecture-https://youtu.be/euobyCF1OMQ
FAQ-What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the
memory at once? Ee can sequentially load K elements and apply either Approach 1 or Approach 2 based on SC.


Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear
as many times as it shows in both arrays and you may return the result in any order.


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
"""


class Solution:
    """
    Most optimized
    Ideation- Hashmap, TC O(m+n) SC- O(min(m, n))
    Hold one array in hashmap and go through second array find intersection in hmap. If there exists current element in hashmap with frequency > 0, add that intersection element in result and reduce it's frequency in hashmap so we don't get duplicates.

    Using hashmap will make the lookup in O(1) in second array reducing time complexity from O(m^2 n) to O(m + n).
    """

    def intersect(self, nums1, nums2):
        hmap = {}
        res = []
        m, n = len(nums1), len(nums2)
        # perform hashmap on smaller array to reduce size
        if m > n:
            return self.intersect(nums2, nums1)
        # fill hashmap
        for num in nums1:
            if num in hmap:
                hmap[num] += 1
            else:
                hmap[num] = 1

        # traverse to nums2 and find intersection using hashmap
        for num in nums2:
            if num in hmap and hmap[num] > 0:
                res.append(num)
                # reduce the frequency of that element in hmap so for syncing
                hmap[num] -= 1
            # else no intersection exists

        return res

    """
    Most optimized (if elements are sorted). TC- O(min(m,n)), SC- O(1)
    Ideation- Two pointer, TC- O((MlogM + NlogN) * min(M,N))  SC- O(1)
    Assume if both the inputs are sorted, we can traverse through both at the same time to find our intersection. We
    can do it by incrementing pointer which is smaller element to try to get close to the larger element in second
    element. When, the smaller element catches upto the larger element and is the same value, add it to the result and
    increment both pointers.

    NOTE- We can also do it without using extra space of result by doing in place replacement in one of the arrays and
    keeping count of number of intersections. Finally, returning that array[:k+1], i.e. first k elements of that
    replaced array.
    """

    def intersect1(self, nums1, nums2):
        res = []
        # sorting since leetcode input is not sorted
        nums1.sort()
        nums2.sort()
        p1, p2 = 0, 0
        # traverse until one of our pointer reaches the end.
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] < nums2[p2]:
                p1 += 1
            elif nums2[p2] < nums1[p1]:
                p2 += 1
            # if the elements are equal
            else:
                res.append(nums1[p1])
                p1 += 1
                p2 += 1

        return res

    """
    Ideation- Binary search, TC- O((MlogM+NlogN) * min(M,N) * min(M,N)log((max(M,N)))) SC- O(1)
    
    Assuming our inputs are sorted, traverse one array and do binary search on the second one. O(mlogN).
    There will be complexities in the way that we will need to handle-
    1. How will we mark the node as visited so it's not considered again? To solve this, we will be finding first occurence of that element in binary search and move the it's low to that element's index + 1. This way it will become out of range of our binary search.
    2. What if target is not in the binary search? We skip that element and move on.
    
    NOTE- Do binary search on larger input to reduce time complexity. Traverse on smaller array and do binary search on bigger.
    """

    def intersect2(self, nums1, nums2):
        res = []
        # sorting since leetcode input is not sorted
        nums1.sort()
        nums2.sort()
        m, n = len(nums1), len(nums2)
        # switch inputs if nums1 is greater than nums2
        if m > n:
            return self.intersect(nums2, nums1)

        # traverse through smaller array nums1
        low, high = 0, n - 1
        for ele in nums1:
            bsIndex = self.binarySearch(nums2, ele, low, high)
            # if target found, add it to result and move range of bs
            if bsIndex != -1:
                res.append(ele)
                # move binary search range onto next element
                low = bsIndex + 1

        return res

    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                # find first occurence of target
                if mid - 1 >= low and arr[mid - 1] == arr[mid]:
                    high = mid - 1
                else:
                    return mid
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        # if target not found
        return -1
