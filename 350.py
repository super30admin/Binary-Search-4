"""Time Complexity: O(m log m + n log n)
Space Complexity: O(1) """
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)== 0 or len(nums2) == 0:
            return []
        m = len(nums1)
        n = len(nums2)
        result = []
        if n < m :
            return self.intersect(nums2, nums1)
        dictionary = defaultdict(int)
        for i in range(m):
            dictionary[nums1[i]] = dictionary.get(nums1[i], 0) + 1
        for j in range(n):
            if dictionary[nums2[j]] !=0 and nums2[j] in dictionary :
                count = dictionary[nums2[j]]
                count = count -1
                result.append(nums2[j])
                dictionary[nums2[j]] = count
        return result