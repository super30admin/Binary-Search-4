from typing import Optional,List
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1,n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        l,h =0,n1
        while l<=h:
            partX = l+(h-l)//2
            partY = (n1 + n2 + 1) // 2 - partX
            X1 = float("-inf") if partX == 0  else nums1[partX-1]
            Y1 = float("inf") if partX == n1 else nums1[partX]
            X2 = float("-inf") if partY == 0  else nums2[partY-1]
            Y2 = float("inf") if partY == n2 else nums2[partY]
            if X1 <=Y2 and X2<=Y1 :
                if (n1+n2) %2 == 0:
                    return (max(X1,X2) +min(Y1,Y2))/2
                else:
                    return max(X1,X2)
            elif X1>Y2:
                h = partX-1
            else:
                l = partX+1
        return -1
