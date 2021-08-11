# Time Complexity : O(mlogm + nlogn)
# Space Complexity : O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        n1 = len(nums1)
        n2 = len(nums2)

        if n2 < n1:
            return self.intersect(nums2,nums1)

        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        out = []
        i,j =0,0

        while i < n1 and j < n2:
            if nums1[i] == nums2[j]:
                out.append(nums1[i])
                i += 1
                j += 1
            elif nums1[i] < nums2[j]:
                i += 1
            else:
                j += 1

        return out