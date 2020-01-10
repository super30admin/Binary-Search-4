# Runs on Leetcode
      # m is length of nums1 and n is length of nums2
      # Solution 1
            # Runtime - O(m+n)
            # Memory - O(m+n)
      # Solution 2
            # Runtime - O(m logm + n logn)
            # Memory - O(1)


# Solution 1

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 and not nums2:
            return []
        result = []
        d= {}
        for i in nums1:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1
        
        for i in nums2:
            if i in d:
                d[i] -= 1
                if d[i] == 0 :
                    del d[i]
                result.append(i)
            else:
                continue
        return result    



# Solution 2

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 and not nums2:
            return []
        result = []
        nums1.sort()
        nums2.sort()
        top = 0
        bottom = 0
        while top < len(nums1) and bottom < len(nums2):
            if nums1[top] == nums2[bottom]:
                result.append(nums1[top])
                top += 1
                bottom += 1
            elif nums1[top] < nums2[bottom]:
                top = top + 1
            else:
                bottom = bottom + 1
        return result
