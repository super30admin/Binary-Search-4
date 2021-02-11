# Time Complexity : O(m+n)
# Space Complexity : O min(m,n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap. Iterate over the smaller array and add the frequencies in HashMap
# Then iterate over the larger array and check if the element is in HashMap if it is then decrement the count by 1
# If the count becomes 0 then remove the element from HashMap
# Append the element to res array
# Return res array


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        if not nums1 or not nums2:
            return res

        dict = {}
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        for i in range(len(nums1)):
            if nums1[i] not in dict:
                dict[nums1[i]] = 1
            else:
                dict[nums1[i]] += 1

        for i in range(len(nums2)):
            if nums2[i] in dict:
                dict[nums2[i]] -= 1
                if dict[nums2[i]] == 0:
                    del dict[nums2[i]]
                res.append(nums2[i])
        return res
