# Time : O(log m) where m  is len (nums1)
# Space: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2,nums1)
        
        # We perform binary search to find the right partition. We perfom this onmly on nums 1 and we will automatically find its corresponding parition in nums2
        low = 0
        high = len(nums1)-1+1 # high = len(nums1) because there is one partition more than the number of indices
        
        while(low<=high):
            partX = low + (high-low)//2
            partY = (len(nums1)+len(nums2))//2 - partX
            
            l1 = nums1[partX-1] if partX > 0 else float("-inf")
            r1 = nums1[partX] if partX < len(nums1) else float("inf")
            l2 = nums2[partY-1] if partY > 0 else float("-inf")
            r2 = nums2[partY] if partY < len(nums2) else float("inf")
            
            if l1<= r2 and l2<=r1:
                # Correct partition
                if (len(nums1)+len(nums2)) %2 ==0:
                    # Length is even
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif l2 > r1:
                low = partX + 1
            else:
                high = partX - 1