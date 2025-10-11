# Time Complexity : O(min(N1, N2)) where N1 and N2 are the lengths of the input arrays
# Space Complexity : O(1) as we are using a constant amount of space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashmap to store the frequency of each element in the first array by using the Counter class from the collections module.
# The counter class creates a dictionary where the keys are the elements and the values are their frequencies
# I am then iterating through the second array and checking if the element is present in the hashmap.
# If it is, I am adding it to the result list and decrementing its frequency in the hashmap.
# If the frequency becomes 0, I am removing the element from the hashmap.
# Finally, I am returning the result list.


from typing import List
from collections import Counter
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
            ans =[]
            hashmap = Counter(nums1)
            for i in nums2:
                if i in hashmap and hashmap[i] > 0:
                    ans.append(i)
                    hashmap[i] -=1
            return ans