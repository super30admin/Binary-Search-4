# Approach
#Get the frequency of the smaller array and iterate over the second array and add thenum in the result


#Complexities
#Time: O(M+N)
#Space: O(N)


from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.intersect(nums2, nums1)

        result = []
        hashMap = dict()
        for num in nums1:
            hashMap[num] = hashMap.get(num, 0) + 1

        for num in nums2:
            if num in hashMap:
                result.append(num)
                hashMap[num] = hashMap.get(num, 0) - 1
                hashMap.pop(num, None) if hashMap[num] == 0 else None
        return result

