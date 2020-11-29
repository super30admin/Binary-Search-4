#Time Complexity : O(log(n)) where n is the length of the smaller array out of both input arrays
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        #always want first input array as smaller one
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        l, h = 0, n1
        while l <= h:
            pX = l + (h-l)//2 #find partition of smaller array
            pY = (n1+n2)//2 - pX #find partition of larger array using partition of smaller array to make sure both left and right partitions of both arrays in total are equal

            #get elements on both sides of the partition on both arrays
            l1 = float("-inf") if pX == 0 else nums1[pX-1]
            l2 = float("-inf") if pY == 0 else nums2[pY-1]
            r1 = float("inf") if pX == n1 else nums1[pX]
            r2 = float("inf") if pY == n2 else nums2[pY]

            #if partitioning has been done correctly
            if l1 <= r2 and l2 <= r1:
                #if total number of elements are of even length
                if (n1+n2)%2 == 0:
                    return (max(l1, l2) + min(r1, r2))/2
                #if total number of elements are of odd length
                else:
                    return min(r1, r2)
            elif l2 > r1:
                l = pX + 1
            else:
                h = pX - 1
