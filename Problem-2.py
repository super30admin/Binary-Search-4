class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n,m = len(nums1), len(nums2)
        
        if n>m:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low, high= 0, n
        
        while(low<=high):
            partX=low + (high-low)//2
            partY=(n+m)//2 - partX
            
            l1=float('-inf') if partX==0 else nums1[partX-1]
            r1=float('inf') if partX==n else nums1[partX]
                
            l2=float('-inf') if partY==0 else nums2[partY-1]
            r2=float('inf') if partY==m else nums2[partY]
                
            if(l1<=r2 and l2<=r1):
                if((n+m)%2==0):
                    return (min(r1,r2)+max(l1,l2))/2
                else:
                    return min(r1,r2)
                
            elif(l2>r1):
                low=partX+1
            else:
                high=partX-1
                
        