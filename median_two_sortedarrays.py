"""
https://leetcode.com/problems/median-of-two-sorted-arrays

"""


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        TC is O(log(min(m,n)))
        SC: O(1)
        """
        if nums1 is None or nums2 is None:
            return 0.00
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0
        high = n1
        while low <= high:
            partx = (low + high) // 2
            party = ((n1 + n2) // 2) - partx
            if partx == 0:
                l1 = -float('inf')
            else:
                l1 = nums1[partx - 1]
            if partx == n1:
                r1 = float('inf')
            else:
                r1 = nums1[partx]
            if party == 0:
                l2 = -float('inf')
            else:
                l2 = nums2[party - 1]
            if party == n2:
                r2 = float('inf')
            else:
                r2 = nums2[party]
            if l1 <= r2 and l2 <= r1:
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            elif l2 > r1:
                low = partx + 1
            else:
                high = partx - 1

        # result=[]
#         for e in nums1:
#             result.append(e)
#         for e in nums2:
#             result.append(e)
#         result.sort()
#         if len(result)%2==0:
#             return (result[len(result)/2]+result[(len(result)/2)+1])/2
#         else:
#             return result[(len(result)+1)/2]


#   ###partition y formula
# """
# (n1+n2)//2 - partition at x
# low = partx+1 of l2>r1
# else high=partx-1
# """