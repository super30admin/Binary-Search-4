class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # Approach: Hashmap O(m+n) time and O(min(m,n)) space
        m = len(nums1)
        n = len(nums2)
        if not m or not n:
            return []
        h = {}
        result = []
        
        if m>n:
            for i in nums2:
                if i not in h.keys():
                    h[i] = 0
                h[i] += 1
            for j in nums1:
                if j in h.keys() and h[j]:
                    result.append(j)
                    h[j] -= 1
        else:
            for i in nums1:
                if i not in h.keys():
                    h[i] = 0
                h[i] += 1
            for j in nums2:
                if j in h.keys() and h[j]!=0:
                    result.append(j)
                    h[j] -= 1
        return result
            