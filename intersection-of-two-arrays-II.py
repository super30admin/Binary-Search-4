# Time O(n1+n2)
# Space O(max(n1,n2))
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # using map
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: self.intersect(nums2, nums1) # have smaller arr as nums1
        f_map = defaultdict(int)
        result = []
        for n in nums2:
            f_map[n] += 1
        for n in nums1:
            if n in f_map:
                result.append(n)
                f_map[n] -= 1
                if f_map[n] == 0: f_map.pop(n)
        return result

# Time O(max(n1,n2) + n log n)
# Space  O(1)   
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # using 2-pointers
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: self.intersect(nums2, nums1) # have smaller arr as nums1
        nums1.sort()
        nums2.sort()
        p1 = 0
        p2 = 0
        result =[]
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result

# Time O(min(n1,n2) * log max(n1,n2))
# Space O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # using 2-pointers
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: self.intersect(nums2, nums1) # have smaller arr as nums1
        nums1.sort()
        nums2.sort()
        low = 0
        result = []
        for n in nums1: # shorter arr loop
            # find first occurance of n
            loc = self.binarySearch(nums2, n, low)
            if loc < n2 and nums2[loc] == n:
                result.append(n)
                low = loc + 1 
        return result

    def binarySearch(self, nums2: List[int], target: int, low: int) -> int:
        high = len(nums2) - 1
        while low <= high:
                mid = low + (high - low) // 2
                if nums2[mid] < target: low = mid + 1
                else : high = mid -1
        return low

               