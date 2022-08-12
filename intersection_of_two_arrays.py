# Time complexity: m= len(nums1), n= len(nums2)
# time complexity: O(m logm)+O(n logn)+O(m+n)-sort both arrays and traverse both the arrays
# Space complexity: O(1)
# Approach: using two pointers- no extra space. Can also be done using hashmap
# Two pointers approach: Sort both the arrays.
# initialise a pointer from index 0 and traverse the arrays. if both index have same numbers,
# add to result. Else increment the pointer with lesser value


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            self.intersect(nums2,nums1)
        p1 = 0
        p2 = 0
        nums1.sort()
        nums2.sort()
        result = []
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1]== nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result
        