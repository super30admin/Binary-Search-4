class Solution:
    # Binary Search with partition technique
    # TC : O(log(m+n))
    # SC : O(1)
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if nums1 is None and nums2 is None:
            return 0
        m,n = len(nums1),len(nums2)
        if m>n:
            return self.findMedianSortedArrays(nums2,nums1)
        low,high = 0,m
        while low <= high:
            partitionX = low + (high-low)//2 # to avoid integer overflow
            partitionY = ((m+n)//2) - partitionX
            l1 = float('-inf') if partitionX == 0 else nums1[partitionX-1]
            r1 = float('inf') if partitionX == m else nums1[partitionX]
            l2 = float('-inf') if partitionY == 0 else nums2[partitionY-1]
            r2 = float('inf') if partitionY == n else nums2[partitionY]
            if l1 <= r2 and l2 <= r1:
                if (m+n)%2 != 0:
                    return min(r1,r2)
                else:
                    return (max(l1,l2)+min(r1,r2))/2
            elif l1 > r2:
                high = partitionX-1
            elif l2 > r1:
                low = partitionX+1
        return float('inf')