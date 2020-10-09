# Leetcode problem link : https://leetcode.com/problems/intersection-of-two-arrays-ii/
# Time Complexity:    O(m+n) /O (mlogm + n logn) for binary search
# Space Complexity:   O(n) for hashmap /O(1) for binary search
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    No extra space : Sort both the arrays and increment pointer for the array with smaller element. As soon as both the pointers have same value in two arrays then add it to output and increment both pointers. Continue till one of the pointer goes out of bounds 
    
    Extra space: Utilise a hashmap to store count for all the values present in one array. Iterate through the other array and keep on decrementing the counter if there is an intersection and add to output. when count becomes zero for an element delete it (optional)

''' 
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        output = []
        
        nums1_map = collections.Counter(nums1)
        
        for num in nums2:
            if num in nums1_map:
                output.append(num)
                if nums1_map[num] > 1:
                    nums1_map[num] -= 1
                else:
                    del nums1_map[num]
        
        return output
                    