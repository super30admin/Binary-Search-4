class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Approach: Hash Map
        #Time Complexity: O(m + n)
        #Space Complexity: O(min(m, n))
        #where m is the length of nums1 and n is the length of nums2
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)     #reducing space complexity
        
        countMap = {}
        result = []
        for num in nums1:
            countMap[num] = countMap.get(num, 0) + 1
        
        for num in nums2:
            if countMap.get(num, 0) > 0:
                result.append(num)
                countMap[num] = countMap.get(num, 0) - 1
        
        return result