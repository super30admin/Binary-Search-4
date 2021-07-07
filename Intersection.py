'''
Solution:
1.  Two solutions can be possible for this, one is without any extra space and one is with
    extra space.
2.  Without extra space, we sort the arrays, maintain two pointers and move them accordingly
    to add common elements to the resultant array whenever they are found.
3.  With extra space, we use a HashMap to maintain count of one array and use those counts 
    to extract common elements from the second array.

Time Complexity:    O(nlogn + mlogm + n + m) - no extra space  |    O(m + n) - extra space
Space Complexity:   O(1) - no extra space  |    O(n) - with extra space, n is length of one array.

--- Passed all testcases successfully on Leetcode. 
'''


class Intersect_NoSpace:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        #   sort the arrays
        nums1.sort()
        nums2.sort()

        #   initializations
        ptr1 = 0;
        ptr2 = 0

        result = []

        #   while both pointers are in bounds
        while (ptr1 < len(nums1) and ptr2 < len(nums2)):

            #   elements matched => move both pointers and add the element to the resultant array
            if (nums1[ptr1] == nums2[ptr2]):
                result.append(nums1[ptr1])
                ptr1 += 1
                ptr2 += 1

            #   if element is lesser in first array => move pointer 1
            elif (nums1[ptr1] < nums2[ptr2]):
                ptr1 += 1

            #   else move pointer 2
            else:
                ptr2 += 1

        #   return the resultant array
        return result


class Intersect_ExtraSpace:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        #   initializations
        nums1CountMap = {}

        #   fill the HashMap
        for i in range(len(nums1)):
            if nums1[i] in nums1CountMap:
                nums1CountMap[nums1[i]] += 1
            else:
                nums1CountMap[nums1[i]] = 1

        #   final resultant array
        result = []

        #   traverse second array, add common elements, decrement their count and remove if zero.
        for i in range(len(nums2)):
            if nums2[i] in nums1CountMap:
                result.append(nums2[i])
                nums1CountMap[nums2[i]] -= 1
                if nums1CountMap[nums2[i]] == 0:
                    del nums1CountMap[nums2[i]]

        #
        return result