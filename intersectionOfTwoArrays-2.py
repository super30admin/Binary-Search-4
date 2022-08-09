class Solution:
    # Time Complexity : O(m+n)
    # Space Complexity : O(1)
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1Map = {}
        for num in nums1:
            if num in nums1Map:
                nums1Map[num]+=1
            else:
                nums1Map[num] = 0
        result = []
        for num in nums2:
            if num in nums1Map and nums1Map[num]>0:
                nums1Map[num]-=1
                result.append(num)
        return result