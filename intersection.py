"""

#brute force method
#create a hashmap and put all the elements of one array into the hashmap along with the count
#iterate through the second array and if the element is present in the hashmap and if the count is not 0, insert the element in the resultant list and decrement the count of the value
class Solution(object):
    def intersect(self, nums1, nums2):
        """
# :type nums1: List[int]
# :type nums2: List[int]
# :rtype: List[int]
# "

"""
        d1={}
        result=[]
        for num in nums1:
            if num not in d1:
                d1[num]=1
            else:
                d1[num]+=1        
        for n in nums2:
            if n in d1.keys() and d1[n]!=0:
                result.append(n)
                d1[n]-=1
        return result
"""


# leetcode
# timecomplexity :O(n)
# space complexity: O(1)
# explination:
# we first sort the arrays.
# we take two piinters i and j and keep iterating rhotugh the array. If the pointers are pointing to the same element, we add that element to the resultant list.
# if the values are smaller, we increment the pointer having lesser while


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # sort the variables and initialise the arrays
        # sort two arraus
        nums1.sort()
        nums2.sort()
        result = []
        # declare  i pointer and j pointer
        i = 0
        j = 0
        while (i < len(nums1) and j < len(nums2)):
            val1 = nums1[i]
            val2 = nums2[j]
            if val1 == val2:
                result.append(val1)
                i += 1
                j += 1

            elif val1 < val2:
                i += 1
            else:
                j += 1
        return result