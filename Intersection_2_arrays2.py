Time - O(N+M) n, m are two given arrays
Space - O(min(N,M))
using hash map and count also after sorting we can do with 2 pointer approach


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dic = {}
        result = []
        for i in nums1:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1
        
        for i in nums2:
            if i in dic and dic[i]>0:
                result.append(i)
                dic[i] -= 1
        return result  
