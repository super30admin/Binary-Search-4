# Time:O(m+n) best
# Space:O(m)
# Leetcode: Yes
# Issues:None
#
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:

        hmap = {}           #   frequency map of nums1
        for i in nums1:
            if i in hmap:
                hmap[i] +=1
            else:
                hmap[i] = 1

        res = []            # output
        for i in nums2:     
            if i in hmap:   #if pr3esent in hmap add to result and remove from hmap
                res.append(i)
                hmap.pop(i)
        return res

# 2 pointers
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:

        # if len(nums1) > len(nums2): return self.intersection(nums2,nums1)

        nums1 = sorted(nums1)
        nums2 = sorted(nums2)

        p1,p2 = 0,0
        res = []

        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                res.append(nums1[p1])
                p1 +=1
                p2 +=1
            elif nums1[p1] < nums2[p2]:
                p1+=1
            else:
                p2+=1

        return list(set(res))

# 1 line soln -_-
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return list(set(nums1).intersection(nums2))
    

#binary search
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:

        if len(nums1) > len(nums2): return self.intersection(nums2,nums1)

        nums1 = sorted(nums1)
        nums2 = sorted(nums2)


        def binarySearch(arr, low, high,target):        #binary Search
            while low <= high:
                mid = low + (high-low)//2
                if arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1
        
        
        res = []
        low,high = 0, len(nums2)-1
        for i in nums1:
            bsIndex = binarySearch(nums2, low, high, i)
            if bsIndex != -1:
                res.append(i)
                low = bsIndex +1

        return list(set(res))




        