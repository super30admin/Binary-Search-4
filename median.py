"""
Get the total and calculate the number of elements to be on the left partion which is total//2
Do binary search on the smaller array to get the elements belonging to left half of array A and with that calculate elemnets belonging to left half in array B
check if if the elements around the partition stisfies the constraints, if teh partition is correct median lies around the edges
TC: O(log(min(m, n)))
SP: O(1)
"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2
        if len(B)<len(A):
            A, B = B, A
        total = len(A)+len(B)
        half = total//2
        l, r = 0, len(A)-1
        while True:
            m = (l+r)//2
            j = half - m -2
            leftA = A[m] if m >=0 else float("-inf")
            leftB = B[j] if j >=0 else float("-inf")
            rightA = A[m+1] if m+1 < len(A) else  float("inf")
            rightB = B[j+1] if j+1 < len(B) else  float("inf")
            if leftA<=rightB and leftB<=rightA:
                if total%2:
                    return min(rightA, rightB)
                return (max(leftA, leftB) + min(rightA, rightB))/2
            if leftA>rightB:
                r=m-1
            else:
                l = m+1
