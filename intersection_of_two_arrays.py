# https://leetcode.com/problems/intersection-of-two-arrays-ii/

# Time Complexity- O(n log n + m log m + min(n, m)) Space Complexity- O(1)

class Solution:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        # sort the both lists
        nums1.sort()
        nums2.sort()
        # find the length of the lists
        n1 = len(nums1)
        n2 = len(nums2)
        # rcursively call the function as we need to iterate on the smaller list
        if n1 > n2:
            return self.intersect(nums2, nums1)
        # initialise the pointer
        p1 = 0
        p2 = 0
        res = []

        while p1 < n1 and p2 < n2:
            # if the both pointers poiting to common element
            if nums1[p1] == nums2[p2]:
                # add into the result list
                res.append(nums1[p1])
                # increase the pointers
                p1 += 1
                p2 += 1
            # if the first element is less than the second element 
            elif nums1[p1] < nums2[p2]:
                # increase the pointer of the first list
                p1 += 1
            else:
                # increase the pointer of the second list
                p2 += 1

        return res


solution = Solution()
print(solution.intersect([1,2,2,1],[2,2]))
        