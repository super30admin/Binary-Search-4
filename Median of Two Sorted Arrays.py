class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #Approach: Binary Search on partitions
        #Time Complexity: O(log(min(n1, n2)))
        #Space Complexity: O(1)
        #where, n1 and n2 are the lengths of nums1 and num2, respectively
        
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n1   #doing Binary Search on n1 + 1 partitions in nums1
        
        while low <= high:
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX
            
            l1 = -float('inf') if partX == 0 else nums1[partX - 1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            l2 = -float('inf') if partY == 0 else nums2[partY - 1]
            r2 = float('inf') if partY == n2 else nums2[partY]
            
            if l1 <= r2 and l2 <= r1:   #found the partition
                if (n1 + n2) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)
            
            elif l1 > r2:
                high = partX - 1
            
            else:
                low = partX + 1
    
    """
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #Approach: Merging, then taking median
        #Time Complexity: O(n1 + n2)
        #Space Complexity: O(n1 + n2)
        #where, n1 and n2 are the lengths of nums1 and num2, respectively
        
        nums = []
        i = j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                nums.append(nums1[i])
                i += 1
            else:
                nums.append(nums2[j])
                j += 1
                
        while i < len(nums1):
            nums.append(nums1[i])
            i += 1
        while j < len(nums2):
            nums.append(nums2[j])
            j += 1
            
        n = len(nums)
        return nums[(n-1)//2] if n % 2 != 0 else (nums[(n-2)//2] + nums[(n)//2]) / 2
    """