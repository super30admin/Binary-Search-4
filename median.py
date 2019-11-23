"""
#BRUTE FORCE
#time complexity: nlogn
#Leetcode:accepted
#merge all the elements of both the arrays into a single array and return the median

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        result=nums1+nums2
        result.sort()
        length=len(result)
        if length%2!=0:
            return result[(length//2)]
        else:
            return (result[length//2]+result[(length//2)-1]) /2
"""


# timecomplexity: log(n)
# space complexity: O(1)
# leetcode:accepted
# explaination: this is like movining one pointer towards right and one towards left so that the total  left elements is equal to the total right elements
# 1.we find the middle partition by low+mid /2 . Do this only for array with less lenth
# 2.find the partition of y by using the formula len(nums1)
# 3. if L1 < R2 and L2 < R1, then we have found the partition, return it

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1 = len(nums1)
        n2 = len(nums2)
        low = 0
        high = n1
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        while low <= high:
            partx = (low + high) // 2
            party = ((n1 + n2 + 1) // 2) - partx

            L1 = -99999 if partx == 0 else nums1[partx - 1]
            R1 = sys.maxsize if partx == n1 else nums1[partx]
            L2 = -99999 if party == 0 else nums2[party - 1]
            R2 = sys.maxsize if party == n2 else nums2[party]

            if L2 > R1:
                low = partx + 1
            elif L1 > R2:
                high = partx - 1
            elif L1 <= R2 and L2 <= R1:
                total = n1 + n2
                if total % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else:
                    return max(L1, L2)
        return -1
