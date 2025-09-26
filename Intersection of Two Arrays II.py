#  Time Complexity : O(m + n)
#  Space Complexity : O(min(m, n)) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english : This code finds the intersection of two arrays with duplicates allowed. It always iterates over the smaller array first to optimize space, storing element counts from nums1 in a hashmap. Then, while scanning nums2, it adds elements to the result if they exist in the hashmap and decrements their count, removing them once used up.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        result = []

        if n1 > n2:
            return self.intersect(nums2, nums1)
        
        map = {}

        for num in nums1:
            map[num] = map.get(num, 0) + 1
        
        for num in nums2:
            if num in map:
                result.append(num)
                map[num] -= 1
                if map[num] == 0:
                    del map[num]
        
        return result
