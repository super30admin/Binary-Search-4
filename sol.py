##problem1

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        nums1.sort()
        nums2.sort()
        res = []
        n1 = len(nums1)
        n2 = len(nums2)
        p1 = 0
        p2 = 0

        while p1 < n1 and p2 < n2:

            if nums1[p1] == nums2[p2]:
                res.append(nums1[p1])
                p1+=1
                p2+=1

            elif nums1[p1] < nums2[p2]:
                p1 +=1
            else:
                p2+=1
        return res


##problem2

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        if len(nums1) > len(nums2):
            nums1,nums2 = nums2,nums1 
        m = len(nums1)
        n = len(nums2)

        low = 0
        hi = len(nums1)

        while low <= hi:
            partition =  (low + hi) // 2
            partition2 = (m + n + 1) //2 - partition

            maxleft1  = float('-inf') if partition == 0 else nums1[partition - 1]
            minright1 = float('inf') if partition == m else nums1[partition]
            maxleft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
            minright2 = float('inf') if partition2 == n else nums2[partition2]

            if maxleft1 <= minright2 and maxleft2 <= minright1:

                if (m + n) % 2 == 0:
                    return (max(maxleft1, maxleft2) + min(minright1, minright2)) / 2
                else:
                    return max(maxleft1,maxleft2)
            elif maxleft1 > minright2:
                hi = partition - 1

            else:
                low = partition + 1