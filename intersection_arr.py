# Time complexity - O(m+n) space = O(min(m,n))
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # 4 solutions possible
        # with sorted binary O(m+nlogn) and two pointers O(m+n)
        # without sorting bruteforce (on*m)) 
        # without sorting hashing - O(m+n) space o(min(m,n))
        
        if not nums1 or not nums2:
            return []
        if len(nums1) > len(nums2):
            self.intersect(nums2, nums1)
        hmap = Counter(nums1)
        res = []
        for num in nums2:
            if num in hmap:
                res.append(num)
                hmap[num] -= 1
                if hmap[num] <= 0:
                    del hmap[num]
        return res


        
        
        
        
        
        
        
        
        
        
        
        
        
        # if not nums1 or not nums2:
        #     return []
    
        # O (m+n) if not sorted
        # res = []
        # hmap = Counter(nums1)
        # for each in nums2:
        #     if each in hmap:
        #         hmap[each] -=1
        #         res.append(each)
        #         if hmap[each] == 0:
        #             hmap.pop(each)
        # return res

        def binSearch(nums2, low, high, target):
            while low <= high :
                mid = low + (high - low) // 2
                if nums2[mid] == target:
                    if mid == low or nums2[mid] > nums2[mid - 1]:
                        return mid 
                    else:
                        high = mid - 1 
                elif nums2[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1

        res = []
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        low = 0 
        high = len(nums2) - 1
        for each in nums1:
            index = binSearch(nums2, low, high, each)
            if index != -1:
                res.append(each)
                low = index + 1
        return res




        # if sorted
        # i = j = 0
        # while i < len(nums1) and j < len(nums2):
        #     if nums1[i] == nums2[j]:
        #         res.append(nums1[i])
        #         i += 1
        #         j += 1
        #     elif nums1[i] < nums2[j]:
        #         i += 1
        #     else:
        #         j += 1
        # return res
