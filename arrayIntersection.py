# TC : O(m+n) as we iterate over both arrays 1 time
# SC : O(min(m,n)) as we pick smaller array to make freq map
class Solution:
   # HashMap
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # This swapping helps us always pick the smaller list in nums1 to create hashMap on
        # this makes hashmap space complexity low.
        if len(nums1) > len(nums2) : return self.intersect(nums2,nums1)
            
        hmap = {}
        res = []
        # create freq map
        for num in nums1:
            hmap[num] = hmap.get(num,0) + 1
        
        for num in nums2:
            if num in hmap:
                hmap[num] -= 1
                if hmap[num] == 0:
                    del hmap[num]
                res.append(num)
        
        return res



class Solution:
   # binary search solution
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # sort
        nums1.sort()
        nums2.sort()
        # to run the binary seach m times where m is the length of smaller array
        # we create references nums and search, where nums is smaller array and search is larger arr
        if len(nums1) > len(nums2) : return self.intersect(nums2,nums1)


        res = []
        low, high = 0, len(nums2) - 1 
        for n in nums1:
            found = self.binary_search(nums2, n, low, high)
            if found != -1:
                res.append(n)
                low = found + 1
        return res
    
    
    def binary_search(self, nums, target, low, high):
         # we want to use <= as we may have target at same location where low and high are equal
        while low <= high:
            # use high-low//2 to avoid overflow if arr is too large
            mid = low + (high-low) // 2
            if nums[mid] == target: # when we find the element
                # if it is at low end of our arr or it is not same as element on its left
                # return the mid
                if mid == low or nums[mid] != nums[mid-1]:
                    return mid
                # else move hight to mid - 1
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
                