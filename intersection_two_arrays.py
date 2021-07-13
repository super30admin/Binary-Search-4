from collections import defaultdict


class Solution:
    hmap = defaultdict()
    result = []

    def updateMap(self, nums):
        for i in nums:
            if i in self.hmap:
                self.hmap[i] = self.hmap[i] + 1
            else:
                self.hmap[i] = 1

    def checkMap(self, nums):

        for i in nums:
            if i in self.hmap:
                self.result.append(i)
                self.hmap[i] = self.hmap[i] - 1
                if self.hmap[i] == 0:
                    self.hmap.pop(i)

    #     Time Complexity: O(m + n)
    #     Space Complexity: O(min(n, m))
    # We will add smaller array element and count to the hmap and we will compare it with longer
    # array size elements and update the results accordingly
    def hmapSolution(self, nums1, nums2):
        self.result = []
        self.hmap = defaultdict()
        n = len(nums1)
        m = len(nums2)
        isFirstLonger = False

        if n < m:
            self.updateMap(nums1)
        else:
            self.updateMap(nums2)
            isFirstLonger = True

        if isFirstLonger:
            self.checkMap(nums1)
        else:
            self.checkMap(nums2)

        return self.result

    # Time Complexity: O(n) - smaller array size
    # Space Complexity: O(1)
    #  We will assign two pointers at the start of both the arrays and sort them first and then till we move the pointer whose value is smaller and if both are equal we willa dd it to the result and move both the pointer
    def twoPointersSolution(self, nums1, nums2):
        self.result = []
        p1 = 0  # for nums1
        p2 = 0  # for nums2
        nums1.sort()
        nums2.sort()

        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                self.result.append(nums1[p1])
                p1 += 1
                p2 += 1

            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return self.result

    def intersect(self, nums1, nums2):

        return self.hmapSolution(nums1, nums2)
        return self.twoPointersSolution(nums1, nums2)

