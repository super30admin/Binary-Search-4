#I combined the two input lists, nums1 and nums2, into a single list num and then sorted this merged list. The median is determined based on the length of the sorted list: if the length is odd, the median is the middle element; if even, it is the average of the two middle elements. This approach, however, has a time complexity of O((m+n) log(m+n)), where m and n are the lengths of the two input arrays, due to the sorting step. The space complexity is O(m+n) because a new list is created to store the combined elements of nums1 and nums2.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        num = nums1 + nums2
        num.sort()
        l = len(num)-1
        if l%2 == 0:
            return num[l//2]
        else:
            return (num[l//2] + num[l//2+1])/2