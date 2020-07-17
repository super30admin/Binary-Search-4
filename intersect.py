3350. Intersection of Two Arrays II
# Time Complexity : O(max(m,n)) where m is length of nums1, n is length of nums2
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#Hashmap
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []
        if len(nums1) > len(nums2):
            temp = nums1
            nums1 = nums2
            nums2 = temp
        mapp = {}
        for i in range(len(nums1)):
            if nums1[i] in mapp:
                mapp[nums1[i]] += 1
                #print(nums1[i])
            else:
                mapp[nums1[i]] = 1
             
        res = []
        for i in range(len(nums2)):
            if nums2[i] in mapp:
                res.append(nums2[i])
                mapp[nums2[i]] -= 1
                if mapp[nums2[i]] == 0:
                    del mapp[nums2[i]]
        return res
# Time Complexity : O(m+n) where m is length of nums1, n is length of nums2
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#two pointers
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2:
            return []
        i = 0
        j = 0
        res = []
        nums1.sort()
        nums2.sort()
        while i < len(nums1) and j < len(nums2):
            if nums1[i] == nums2[j]:
                res.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                i += 1
        return res

# Time Complexity : O(log(m+n)) where m is length of nums1, n is length of nums2
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
#Binary Search
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1
        res = []
        nums1.sort()
        nums2.sort()
        index = 0
       
    def bsearch(self,nums,target,low,high):
        while low <= high:
            mid = low + high // 2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid -1
            elif nums[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1
        for i in nums1:
            bsindex = self.bsearch(nums2,i,index,len(nums2)-1)
            if bsindex != -1:
                print(bsindex)
                index = bsindex + 1
                res.append(nums2[bsindex])
                
        return res
        
            
        