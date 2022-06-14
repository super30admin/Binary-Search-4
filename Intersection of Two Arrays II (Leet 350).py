# Hashmap
# Time: O(m+n)
# Space: O(min(m,n))

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m = len(nums1)
        n = len(nums2)
        
        if m > n:
            self.intersect(nums2, nums1)
        
        temp = dict()
        res = list()
        
        for num in nums1:
            if num not in temp:
                temp[num] = 1
            else:
                temp[num] += 1
        
        for num in nums2:
            if num in temp:
                res.append(num)
                temp[num] -= 1
                if temp[num] == 0:
                    del temp[num]
        
        return res




# Two pointers (Consider if arrays are already sorted)
# Time: O(m+n)
# Space: O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        res = list()
        
        nums1.sort()
        nums2.sort()
        
        p = 0
        q = 0
        
        while p < len(nums1) and q < len(nums2):
            
            if nums1[p] == nums2[q]:
                res.append(nums1[p])
                p += 1
                q += 1
            else:
                if nums1[p] < nums2[q]:
                    p += 1
                else:
                    q += 1
        
        return res


# Binary Search
# Logic - Get the first occurance index in binary search
# Time: mlogn, where m is len of nums1 and n is len of nums2
# Space: O(1)


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        nums1.sort()
        nums2.sort()
        
        res = list()
        m = len(nums1)
        n = len(nums2)
        
        if m > n:
            self.intersect(nums2, nums1)
        
        l = 0
        r = len(nums2) - 1
        for num in nums1:
            ind = self.binary_search(nums2, l, r, num)
            if ind != -1:
                l = ind + 1
                res.append(num)
            
        return res
    
    def binary_search(self, arr, l, r, target):
        while l <= r:
            m = l + (r-l)//2
            if arr[m] == target:
                if m == l or arr[m-1] < arr[m]:
                    return m
                else:
                    r = m - 1
            elif arr[m] > target:
                r = m - 1
            else:
                l = m + 1
        return -1