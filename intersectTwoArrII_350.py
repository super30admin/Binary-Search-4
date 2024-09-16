# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Your approach:

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        hmap = {}
        output = []
        
        #let nums1 be the bigger array
        if len(nums1)<len(nums2):
            return self.intersect(nums2, nums1)
            
        #add to hashmap, if already exists then ncrease the count
        for num in nums1:
            if num not in hmap.keys():
                hmap[num] = 1
            else:
                hmap[num] += 1
        
        #on every encounter, check hashmap: if value is present decrease count and add to output
        for num in nums2:
            if num in hmap and hmap[num]>0:
                hmap[num] -= 1
                output.append(num)
                
        return output
        