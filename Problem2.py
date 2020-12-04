# Time Complexity: O (n + m)(Where n is length of first array and m is length of second array)
# Space Complexity: O(n) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# First approach:
# - Store element count in dictionary of any one array.
# - Parse through second array and if that element count is grater than 0 in dictionary than reduce count by 1 and append the element to the answer list.

# For follow up question if elements are sorted:
# Time Complexity: O (n log n + m log m + m + n)(Where n is length of first array and m is length of second array)
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# Second approach:
# - Start with fisrt index of both arrays in while loop and exit loop when any of index is out of bound.
# - If any of the two element is small increase its index, otherwise increase both index and append the element to the answer.

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        data = {}
        ans = []       
#       Store element count in dictionry for first array 
        for i in range(len(nums1)):
            data[nums1[i]] = data.get(nums1[i], 0) + 1         
#       Itereate over second array
        for j in range(len(nums2)):
#           If elemnet is in the dictionary and it's count is more than zero, append it to answer and reduce count by 1.
            if nums2[j] in data and data[nums2[j]] > 0:
                data[nums2[j]] -= 1
                ans.append(nums2[j])              
        return ans
    
    def intersect(self, nums1, nums2):
#       Sort both Arrays
        nums1.sort()
        nums2.sort()
#       Initilize start index for both array
        i, j = 0, 0
        ans = []
#       Breaking condition is if any of the index reach at the end
        while (i < len(nums1) and j < len(nums2)):
#           If element is smaller in first array than increase it's index by 1 and vise verca.
            if nums1[i] < nums2[j]:
                i += 1
            elif nums2[j] < nums1[i]:
                j += 1
#           If same element is found than append it to answer and increase both index.
            else:
                ans.append(nums1[i])
                i += 1
                j += 1
        return ans
    
            
