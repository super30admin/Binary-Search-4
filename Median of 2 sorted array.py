# TC O(logN) - N is the length of smaller array
# SC O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) > len(nums2) : return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = len(nums1)
        n1, n2 = len(nums1), len(nums2)
        avg = (n1+n2)//2
        while low <= high:
            x = low + (high - low) // 2
            y = avg - x
            
            l1 = nums1[x-1] if (x-1) >= 0 else float("-inf") 
            l2 = nums2[y-1] if (y-1) >= 0 else float("-inf") 
            r1 = nums1[x] if x < n1 else float("inf") 
            r2 = nums2[y] if y < n2 else float("inf") 

            if l1 <= r2 and l2 <= r1:
                break
            elif l1 > r2:
                high = x - 1
            else:
                low = x + 1
        
        return min(r1,r2) if (n1+n2) % 2 == 1 else (max(l1,l2) + min(r1,r2)) / 2