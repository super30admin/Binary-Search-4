#Time complexity: O(m+n) as we are iterating through both the nums array
#Space: O(min(m,n)) as we are putting the smaller array in hashmap

# The logic is to have a count of freq of smaller array in a map, then iterate through the other array to check if it exist, if it does then reduce the freq and add it to result

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1

        result = []
        nums1Map = {}
        for num in nums1:
            nums1Map[num] = 1 + nums1Map.get(num, 0)

        for num in nums2:
            if num in nums1Map:
                result.append(num)
                nums1Map[num] -= 1
                if nums1Map[num] == 0:
                    del nums1Map[num]

        return result

