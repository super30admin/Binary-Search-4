#350. Intersection of Two Arrays II

from collections import defaultdict
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) < len(nums2):
            return self.helper(nums1, nums2)
        else:
            return self.helper(nums2, nums1)
    

    def helper(self, list1, list2):
        result = []
        numberOccurence = defaultdict(int)

        for num in list1:
            numberOccurence[num]+=1
        

        for num in list2:
            if num in numberOccurence:
                result.append(num)
                numberOccurence[num]-=1
                if numberOccurence[num] == 0:
                    del numberOccurence[num]
        return result