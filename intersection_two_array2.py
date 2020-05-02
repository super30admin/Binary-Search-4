"""
// Time Complexity : O(m + n)
// Space Complexity : O(1) if arrays are already sorted
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to use a Counter dictionary of nums
Iterate over nums2 and decrement the counter for corresponding number
and add to the result only if counter is greater than 0
Time - O(m + n), Space - O(m)

Two pointer approach for Followup quest
- Initial configuration - p1-0(pointing to nums1), p2-0(pointing to nums2), result = []
- Iterate while p1 and p2 don't exhaust respective array lengths
    - if value at p1 = value at p2
        - append value at p1 to result
    - if value at p1 < value at p2
        - increment p1
    - else increment p2
- return results
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

        #Followup2 when the arrays are sorted - Two pointer approach
        nums1.sort()
        nums2.sort()
        p1,p2 = 0,0
        
        result = []
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1] < nums2[p2]:
                p1+=1
            else:
                p2+=1
        return result