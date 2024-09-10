# Time complexity - O(log(min(m,n))
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        if len(nums2) < len(nums1):
            return self.findMedianSortedArrays(nums2, nums1)
        n1 = len(nums1)
        n2 = len(nums2)
        low, high = 0, n1 # no of partitions = len = no of elements + 1
        while (low <= high):
            part_X = low + ((high - low) // 2 )
            part_Y = (n1+n2)//2 - part_X
            leftA = nums1[part_X-1] if part_X > 0 else float('-inf')
            leftB = nums2[part_Y-1] if part_Y > 0 else float('-inf')
            rightA = nums1[part_X] if part_X < n1 else float('+inf')
            rightB = nums2[part_Y] if part_Y < n2 else float('+inf')
            if leftA <= rightB and leftB <= rightA:
                # right partition found
                if (n1+n2)%2 == 0:
                    return (min(rightA, rightB) + max(leftA, leftB)) / 2
                else:
                    return min(rightA, rightB)
            elif leftA > rightB:
                high = part_X -1
            else: low = part_X + 1

        return 0







        # 4 11 15 18 22
        # 1 3 7 10 13 20

        # if len(nums1) > len(nums2):
        #     nums1, nums2 = nums2, nums1
        
        # start = 0
        # end = len(nums1)

        # while start <= end:
        #     pA = (start + end) // 2
        #     pB = (len(nums1) + len(nums2) + 1) // 2 - pA

        #     # print(pA, pB)
        #     leftA = float("-inf") if pA - 1 < 0 else nums1[pA - 1]
        #     leftB = float("-inf") if pB - 1 < 0 else nums2[pB - 1]
        #     rightA = float("inf") if pA >= len(nums1) else nums1[pA]
        #     rightB = float("inf") if pB >= len(nums2) else nums2[pB]

        #     if leftA <= rightB and leftB <= rightA:
        #         # found our partition
        #         if (len(nums1) + len(nums2)) % 2 == 0:
        #             return (max(leftA, leftB) + min(rightA, rightB)) / 2
        #         else:
        #             return max(leftA, leftB)

        #     if leftA > rightB:
        #         end = pA - 1
        #     else:
        #         start = pA + 1
        
