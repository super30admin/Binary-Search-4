# TC : O((N+M)log(N+M))
# SC : O(N + M)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums1.extend(nums2)
        nums1=sorted(nums1)
        if len(nums1)%2 == 0:
            return ((nums1[len(nums1)//2] + nums1[(len(nums1)//2)-1])/2)
        else:
            return nums1[((len(nums1)+1)//2)-1]

        