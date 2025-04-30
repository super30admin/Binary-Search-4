'''
    Time Complexity(if the arrays are already sorted): O(mlogn)
    Space Complexity: O(1)
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)
        result = []

        nums1.sort()
        nums2.sort()

        lastlow = 0

        for num in nums1:
            low = lastlow
            high = n-1

            while low <= high:
                mid = low + (high - low) // 2

                if nums2[mid] == num and (mid == low or nums2[mid-1] != num):
                    result.append(num)
                    lastlow = mid+1
                    break
                elif nums2[mid] < num:
                    low = mid + 1
                else:
                    high = mid - 1

        return result