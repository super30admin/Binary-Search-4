# Time complexity - O(m+n) where m,n :length of two given arrays.
# Space Complexity: O(n) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Use hashmap method, find the smaller array between the given arrays and make a hashmap.
#            After that, if there is a match, add to the result and dec the count from the hashmap.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:       
                
        res= []
        hashmap = {}

        if not nums1 or len(nums1) == 0 or not nums2 or len(nums2) == 0:
            return res

        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)

        # store counts for smaller array
        for num in nums1:
            if num not in hashmap:
                hashmap[num] = 1
            else:
                hashmap[num] += 1


        for num in nums2:
            if num in hashmap:
                res.append(num)
                hashmap[num] -= 1
                if hashmap[num] == 0:
                    del hashmap[num]

        return res