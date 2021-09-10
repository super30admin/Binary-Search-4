"""
Time Complexity : O(n+m) where n and m are length of nums1 and nums2 respectively
Space Complexity : O(n) where n is min(n, m) coz we store min array in map
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) == 0 or len(nums2) == 0:
            return []
        n1 = len(nums1)
        n2 = len(nums2)
        result = []
        mapD = {}
        # If nums2 if bigger we simple call the intersect function again and 
        # pass the arrays interchanged
        if n1 > n2:
            return self.intersect(nums2, nums1)
        # Now we iterate through the smaller array and add the frequency counts
        # as we see them
        for num in nums1:
            if num not in mapD:
                mapD[num] = 1
            else:
                mapD[num] += 1
        # We iterate through the bigger array and if the num is found in the hash map
        # we append it to the final result and if the frequency is greater then 1 in 
        # the map we decrement it and it not i.e 0 then we delete it from the map
        for num in nums2:
            if num in mapD:
                result.append(num)
                if mapD[num] > 1:
                    mapD[num] -= 1
                else:
                    del mapD[num]
        return result