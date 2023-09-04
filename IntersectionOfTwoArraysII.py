#TC: O(1)
#SC: O(n)

class Intersect_NoSpace:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        nums1.sort()
        nums2.sort()

        ptr1 = 0;
        ptr2 = 0

        result = []

        while (ptr1 < len(nums1) and ptr2 < len(nums2)):

            if (nums1[ptr1] == nums2[ptr2]):
                result.append(nums1[ptr1])
                ptr1 += 1
                ptr2 += 1

            elif (nums1[ptr1] < nums2[ptr2]):
                ptr1 += 1

            else:
                ptr2 += 1

        return result


class Intersect_ExtraSpace:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        nums1CountMap = {}

        for i in range(len(nums1)):
            if nums1[i] in nums1CountMap:
                nums1CountMap[nums1[i]] += 1
            else:
                nums1CountMap[nums1[i]] = 1

        result = []

        for i in range(len(nums2)):
            if nums2[i] in nums1CountMap:
                result.append(nums2[i])
                nums1CountMap[nums2[i]] -= 1
                if nums1CountMap[nums2[i]] == 0:
                    del nums1CountMap[nums2[i]]

        return result