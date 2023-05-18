# Time Complexity: O(n + m)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
Here we find similar elements in the two arrays by using Counter. We iterate over the second array and 
check if the element is present in the hashmap. If it is present, we add it to the answer array and 
decrement the count in the hashmap. We return the answer array in the end.
"""

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hashmap = Counter(nums1)

        answer = []
        for number in nums2:
            if hashmap[number] > 0:
                answer.append(number)
                hashmap[number] -= 1

        return answer