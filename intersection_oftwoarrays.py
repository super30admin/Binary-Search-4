# Count the frequency of elements in both arrays
# Iterate through one of the count dictionaries
# Append the common element the minimum number of times it appears in both arrays

#TC-O(n + m)
#SC-O(n + m)
from collections import Counter
class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        
        count1 = Counter(nums1)
        count2 = Counter(nums2)
        result = []   
        for num, freq in count1.items():
            if num in count2:
               
                result.extend([num] * min(freq, count2[num]))
        
        return result
    
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
solution = Solution()
print(solution.intersect(nums1, nums2))  

nums1 = [4, 9, 5]
nums2 = [9, 4, 9, 8, 4]
print(solution.intersect(nums1, nums2))  