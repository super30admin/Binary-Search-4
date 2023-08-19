# Time Complexity:O(n)
# Space Complexity: O(min(n,m))
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hmap = {}
        result =[]
        for i in nums1:
            if i in hmap:
                hmap[i] = hmap[i] + 1
            else:
                hmap[i] = 1
        for i in nums2:
            if i in hmap:
                hmap[i] = hmap[i] - 1
                result.append(i)
                if hmap[i] == 0:
                    del hmap[i]
                
        return result
    



                
        