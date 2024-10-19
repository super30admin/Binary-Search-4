'''
1. Method 1 is by sorting both the arrays and maintaining 2 pointers that keep track of common elements and append to result array moving forward.
2. Method 2 is assuming one array is using Hashmap for counts of ele in nums1. We then traverse over nums2 and decrement count to maintain exact number of elements found in both arrays.
3. Method 3 is using binary search to search for elements of nums2/nums1 in nums1/nums2 based on their lengths - sorting the smaller one and also counter to maintain exact number of elements found in both arrays


TC: 
1. O(nlogn)
2. O(n)
3. O(nlog(n))

SC:
1. O(1)
2. O(n)
3. O(n)
'''
from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:


        # Method 1
        # nums1.sort()
        # nums2.sort()
        # i = 0
        # j = 0
        # res = []
        # while i < len(nums1) and j < len(nums2):
        #     if nums1[i] == nums2[j]:
        #         res.append(nums1[i])
        #         i += 1
        #         j += 1
        #     elif nums1[i] > nums2[j]:
        #         j += 1
        #     else:
        #         i += 1
        # return res
        
        # Method 2
        # res = []
        # counts1 = defaultdict(int)
        # for i in nums1:
        #     counts1[i] += 1
        # for j in nums2:
        #     if j in counts1 and counts1[j] > 0:
        #         res.append(j)
        #         counts1[j] -= 1
        # return res
        
        # Method 3
        res = []
        if len(nums1) < len(nums2):
            nums1.sort()
            counts1 = defaultdict(int)
            for i in nums1:
                counts1[i] += 1
            for i in nums2:
                if self.binarySearch(i, 0, len(nums1) - 1, nums1) and counts1[i] > 0:
                    res.append(i)
                    counts1[i] -= 1
        else:
            nums2.sort()
            counts2 = defaultdict(int)
            for i in nums2:
                counts2[i] += 1
            for i in nums1:
                if self.binarySearch(i, 0, len(nums2) - 1, nums2) and counts2[i] > 0:
                    res.append(i)
                    counts2[i] -= 1
        return res

    def binarySearch(self, i, l, r, nums):
        if l > r:
            return 
        mid = (l + r) // 2
        if nums[mid] == i:
            return True
        if nums[mid] > i:
            r = mid - 1
        elif nums[mid] < i:
            l = mid + 1
        return self.binarySearch(i, l, r, nums)
        