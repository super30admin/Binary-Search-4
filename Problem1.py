"""Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order."""

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dic = {}
        arr = []
        for i in nums1:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] = dic.get(i)+1
        for i in nums2:
            if i in dic:
                if dic.get(i)>=1:
                    arr.append(i)
                    dic[i] = dic.get(i)-1
                    
        return arr
                
            
        