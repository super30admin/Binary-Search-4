#-------- Solution 1: hashmap --------
''' Time Complexity : O(m + n) 
    Space Complexity : O(max(m,n)) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hashmap = {}
        result = []
        for num in nums1:
            hashmap[num] = hashmap.get(num,0) + 1
        for num in nums2:
            if num in hashmap:
                hashmap[num] -= 1
                result.append(num)
                if hashmap[num] == 0:
                    hashmap.pop(num)
        return result