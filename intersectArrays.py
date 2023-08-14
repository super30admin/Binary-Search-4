#TC - O(n)
#SC - O(n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        c=Counter(nums1)
        op=[]
        for n in nums2:
            if c[n]>0:
                op.append(n)
                c[n]-=1
        return op