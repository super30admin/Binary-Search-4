class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # Idea : Create a hashmap to count values of one list and Find the intersection by iterating through other list
        # Time Complexity: O(N + M) (N,M size of two list)
        # Space Complexity: O(N) where N is size of nums1, we can optimize by storing the smaller list in hashmap
        # If both arrays are sorted, then we can use two pointers to iterate through arrays and find the overlapping elements.
        output = []
        hmap = {}
        if not nums1 or not nums2:
            return output
        for val in nums1:
            if val not in hmap.keys():
                hmap[val] = 1
            else:
                hmap[val] += 1
        for val in nums2:
            if val in hmap.keys() and hmap[val] > 0:
                output.append(val)
                hmap[val] -= 1
        return output
