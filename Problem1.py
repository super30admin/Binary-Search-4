#Time Complexity :- O(n+m)
#Space Complexity :- O(n)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hashMap = {}
        totalArray = []
        for i in range(len(nums1)):
            if nums1[i] not in hashMap:
                hashMap[nums1[i]] = 0
            hashMap[nums1[i]]= hashMap[nums1[i]] + 1
        
        for i in range(len(nums2)):
            if nums2[i] in hashMap:
                hashMap[nums2[i]] =hashMap[nums2[i]] - 1
                if hashMap[nums2[i]] == 0:
                    del hashMap[nums2[i]]
                totalArray.append(nums2[i])
        return totalArray


