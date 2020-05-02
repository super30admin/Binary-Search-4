"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to use a Counter dictionary of nums
Iterate over nums2 and decrement the counter for corresponding number
and add to the result only if counter is greater than 0
Time - O(m + n), Space - O(m)
"""




from collections import Counter
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1_map  = Counter(nums1)
        result = []
        if not nums1 or not nums2:
            return []
        
        for i in nums2:
            if i in nums1_map:
                nums1_map[i] -=1
                if nums1_map[i] >=0:
                    result.append(i)
        return result
        