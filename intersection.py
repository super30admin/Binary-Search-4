# TC: O(Min(m, n) x Log(Max(m, n))) - m, n  - size of nums1 and nus2
# SC: O(1)

class Solution:
    def linearSol(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d_arr, iter_arr = (nums1, nums2) if len(nums1) < len(nums2) else (nums2, nums1)
        result = []
        d = {}
        for val in d_arr:
            d[val] = d.get(val, 0) + 1
        for val in iter_arr:
            if d.get(val, None) is not None and d.get(val, None) > 0:
                d[val] -= 1
                result.append(val)
        
        return result
        
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # ans = self.linearSol(nums1, nums2)
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        iterArr, bsArr = (nums1, nums2) if len(nums1) < len(nums2) else (nums2, nums1)
        result = []
        def binarySearchFirst(arr, target):
            
            start, end = 0, len(arr) - 1
            
            while start <= end:
                mid = start + (end - start) // 2
                if (mid == 0 or arr[mid] > arr[mid-1]) and arr[mid] == target:
                    return mid
                elif arr[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        def binarySearchLast(arr, target):
            
            start, end = 0, len(arr) - 1
            
            while start <= end:
                mid = start + (end - start) // 2
                if (mid == len(arr)-1 or arr[mid] < arr[mid+1]) and arr[mid] == target:
                    return mid
                elif arr[mid] > target:
                    end = mid - 1
                else:
                    start = mid + 1
            return -1
        
        n = len(iterArr)
        i = 0
        while i < n:
            val = iterArr[i]
            s = binarySearchFirst(bsArr, val)
            e = binarySearchLast(bsArr, val)
            if s+e < 0:
                while i<n-1 and iterArr[i] == iterArr[i+1]:
                    i += 1
                i += 1
                continue
            total = e-s+1
            ct = 0
            while i<n-1 and iterArr[i] == iterArr[i+1]:
                if ct < total:
                    result.append(iterArr[i])
                    ct += 1
                i += 1
            if ct < total:
                result.append(iterArr[i])
            i += 1
            
        return result