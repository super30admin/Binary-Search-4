class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        arr = []
        i = 0
        j = 0
        m = len(nums1)
        n = len(nums2)
        while i <m and j< n:
            if nums1[i] <= nums2[j]:
                arr.append(nums1[i])
                i = i + 1
            else:
                arr.append(nums2[j])
                j = j + 1
        if j  == len(nums2):
            for k in range(i, len(nums1)):
                arr.append(nums1[k])
        else:
            for k in range(j, len(nums2)):
                arr.append(nums2[k])
                
        if (m+n)%2 == 0:
            return (arr[(m+n)//2] + arr[(m+n)//2 - 1])/2
        else:
            return arr[(m+n)//2]
            