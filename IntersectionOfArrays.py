# Problem1 Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: 
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        p1 = p2 = 0
        result = []
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result

# Time complexity: O(max(N1 log N1, N2 log N2))
# Space complexity: O(min(N1, N2))
# The time complexity is dominated by the sorting step, which has a time complexity of O(N log N) for each array. Since we are sorting both arrays, the overall time complexity is O(max(N1 log N1, N2 log N2)). The space complexity is O(min(N1, N2)) as it depends on the size of the smaller array.