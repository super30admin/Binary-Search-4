# TC: O(min(log M, log N)) where M is the size of the input array 1 and N is the size of the input array2. Since, we just perform binary sort on the array with smaller size. 
# SC: O(1) since we do not use any extra space.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n1 > n2: 
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0 
        high = n1 
        while low <= high: 
            partX = (low + high) // 2
            partY = ((n1 + n2 - 1) // 2) - partX
            l1 = float('-inf') if partX == 0 else nums1[partX - 1]
            r1 = float('inf')  if partX == n1 else  nums1[partX]
            l2 = float('-inf') if partY == 0 else nums2[partY - 1]
            r2 = float('inf') if partY == n2 else nums2[partY]

#           when we reach the correct partition             
            if l1 <= r2 and l2 <= r1:
#           if the combined array makes an even number
                return (max(l1,l2) + min(r1,r2)) / 2 if (n1 + n2) % 2 == 0 else min(r1,r2)

#    when l2 > r1, r1 is smaller than next positioned value in combined array, so we will need to shift the range to right side.  
            elif l2 > r1:
                low = partX + 1
            
#             else shift towards left side
            elif l1 > r2: 
                high = partX - 1
        
        return 99.00
