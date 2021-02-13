# TC: O(nlogn)
# SC: O(n) of ans

# Yes, it ran on leetcode
# problem - not able to optimize
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        res = nums1+nums2
        res.sort()
        l = len(res)
        if l%2==0:
            m1 = res[l//2]
            m2 = res[l//2-1]
            ans = (m1+m2)/2
        else:
            ans = res[(l//2)]
        return ans