class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Hash Map solution
        # result = []
        # hmap = collections.defaultdict(int)
        # # Fill the hashmap with values from nums1
        # for i in nums1:
        #     hmap[i] += 1

        # for j in nums2:
        #     if j in hmap:
        #         if hmap[j] > 0:
        #             result.append(j)
        #         hmap[j] -= 1
        # return result

        # Two Pointer Approach
        # Time Complexity: O(nlogn + mlogm + (n+m))
        # Space Complexity: O(1)
        # result = []
        # nums1.sort() # nlogn
        # nums2.sort() # mlogm
        # p1 = 0
        # p2 = 0
        # while p1 < len(nums1) and p2 < len(nums2): # n + m
        #     if nums1[p1] < nums2[p2]:
        #         p1 += 1
        #     elif nums1[p1] > nums2[p2]:
        #         p2 += 1
        #     else:
        #         result.append(nums1[p1])
        #         p1 += 1
        #         p2 += 1
        # return result

        # Binary Search Approach
        # Time Complexity: O(nlogn + mlogm + nlogm)
        def bsearch(val, low, high):

            while low <= high:
                mid = low + (high - low) // 2
                if val > nums2[mid]:
                    low = mid + 1
                elif val < nums2[mid]:
                    high = mid - 1
                else:
                    if mid > low and nums2[mid - 1] == nums2[mid]:
                        high = mid - 1
                    else:
                        # print("here", mid)
                        return mid
            return -1

        result = []
        low = 0
        nums1.sort()  # nlogn
        nums2.sort()  # mlogm
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        # print(nums1)
        for i in nums1:  # nlogm
            new_low = bsearch(i, low, len(nums2) - 1)
            if new_low != -1:
                # print(new_low)
                result.append(i)
                low = new_low + 1
        return result
