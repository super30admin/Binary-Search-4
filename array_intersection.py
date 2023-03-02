# Approach 1
# Time Complexity: O(n)
# Space Complexity: O(min(m,n))

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        hashMap = collections.defaultdict()

        for num in nums1:
            if num in hashMap.keys():
                hashMap[num] += 1
            else:
                hashMap[num] = 1
        res = []
        for num in nums2:
            if num in hashMap.keys():
                res.append(num)
                f = hashMap[num]
                if f == 1:
                    hashMap.pop(num, None)
                else:
                    hashMap[num] -= 1
        return res

# Approach 2:
# Time Complexity: O(nLogm)
# Space Comlexity: O(1)


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []

        # keep larger array in nums2
        if (len(nums1) > len(nums2)):
            nums1, nums2 = nums2, nums1

        def binarySearch(l, r, nums2, target):
            while (l <= r):
                mid = (l + r) // 2
                print(l, r, mid)
                if (nums2[mid] == target):
                    if (mid == l or nums2[mid-1] != target):
                        return mid
                    r = mid - 1
                elif nums2[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            return -1

        start = 0
        for num in nums1:
            index = binarySearch(start, len(nums2)-1, nums2, num)
            print(index)
            if index != -1:
                result.append(num)
                start = index+1

        return result
