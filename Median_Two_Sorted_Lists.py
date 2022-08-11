class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m=len(nums1)
        n=len(nums2)
        
        if n<m:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low=0
        high=m
        
        while low<=high:
            partition_x=low+(high-low)//2
            partition_y=(m+n)//2-partition_x
            
            l1=-math.inf if partition_x==0 else nums1[partition_x-1]
            l2=-math.inf if partition_y==0 else nums2[partition_y-1]
            r1=math.inf if partition_x==m else nums1[partition_x]
            r2=math.inf if partition_y==n else nums2[partition_y]
            
            if l1<=r2 and l2<=r1:
                if (m+n)%2==0:
                    return (max(l1,l2)+min(r1,r2))/2
                return min(r1,r2)
                
            elif l1>r2:
                high=partition_x-1
                
            else:
                low=partition_x+1
                
        return 0.0
                
                
            
        
        