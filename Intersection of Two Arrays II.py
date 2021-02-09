class Solution:
    #Solution 1
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Approach: Hash Map
        #Time Complexity: O(m + n)
        #Space Complexity: O(min(m, n))
        #where m is the length of nums1 and n is the length of nums2
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)     #reducing space complexity
        
        countMap = {}
        result = []
        for num in nums1:
            countMap[num] = countMap.get(num, 0) + 1
        
        for num in nums2:
            if countMap.get(num, 0) > 0:
                result.append(num)
                countMap[num] = countMap.get(num, 0) - 1
        
        return result
    
    #Solution 2
    """
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Approach: Binary Search; for when the arrays are given sorted
        #Time Complexity: O(min(log m + n, m + log n))      //exluding sorting
        #Space Complexity: O(1)
        #where m is the length of nums1 and n is the length of nums2
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)     #keeping nums1 smaller
        
        nums1.sort()
        nums2.sort()
        
        result = []
        
        low = 0
        for i in range(n1):
            num = nums1[i]
            bsIndex = self.binarySearch(nums2, num, low, n2 - 1)
            if bsIndex != -1:
                result.append(num)
                low = bsIndex + 1
        
        return result
            
    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target and (mid == low or arr[mid - 1] < arr[mid]):
                return mid
            elif arr[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    """
    
    #Solution 3
    """
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Approach: Binary Search with Two Pointers; for when the arrays are given sorted
        #Time Complexity: O(min(log m + n, m + log n))      //exluding sorting
        #Space Complexity: O(1)
        #where m is the length of nums1 and n is the length of nums2
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)     #keeping nums1 smaller
        
        nums1.sort()
        nums2.sort()
        
        result = []
        
        i = 0
        low = 0
        while i < n1:
            num = nums1[i]
            i += 1
            count = 1
            while i < n1 and nums1[i] == num:
                count += 1
                i += 1
            bsIndex = self.binarySearch(nums2, num, low, n2 - 1)
            bsIndex_low, bsIndex_high = bsIndex - 1, bsIndex
            if bsIndex != -1:
                while count != 0 and (bsIndex_low >= 0 or bsIndex_high < n2):
                    if bsIndex_low >= 0 and nums2[bsIndex_low] == num:
                        result.append(num)
                        count -= 1
                        bsIndex_low -= 1
                    elif bsIndex_high < n2 and nums2[bsIndex_high] == num:
                        result.append(num)
                        count -= 1
                        bsIndex_high += 1
                    else:
                        break
            
                low = bsIndex_high
        
        return result
            
    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    """
    
    #Solution 4
    """
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Approach: Binary Search with Two Pointers; for when the arrays are given sorted
        #Time Complexity: O(min(log m + n, m + log n))      //exluding sorting
        #Space Complexity: O(1)
        #where m is the length of nums1 and n is the length of nums2
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.intersect(nums2, nums1)     #keeping nums1 smaller
        
        nums1.sort()
        nums2.sort()
        
        result = []
        
        i = 0
        low = 0
        while i < n1:
            num = nums1[i]
            i += 1
            count = 1
            while i < n1 and nums1[i] == num:
                count += 1
                i += 1
            bsIndex = self.binarySearch(nums2, num, low, n2 - 1)
            if bsIndex != -1:
                while count != 0 and bsIndex < n2:
                    if nums2[bsIndex] == num:
                        result.append(num)
                        count -= 1
                        bsIndex += 1
                    else:
                        break
            
                low = bsIndex
        
        return result
            
    def binarySearch(self, arr, target, low, high):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == target and (mid == low or arr[mid - 1] < arr[mid]):
                return mid
            elif arr[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    """