#Time: O(logm)
#Space: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        n1 = len(nums1); n2 = len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low =0; high = n1
        while low<=high:
            partx = low + (high-low)//2
            party = (n1+n2)//2 - partx
            l1 = float('-inf') if partx==0 else nums1[partx-1]
            l2 =  float('-inf') if party==0 else nums2[party-1]
            r1 =  float('inf') if partx==n1 else nums1[partx]
            r2 =  float('inf') if party==n2 else nums2[party]
            
            if l1<=r2 and l2<=r1:
                if (n1+n2)%2==0:
                    return (max(l1,l2)+min(r1,r2) )/2
                else:
                    return min(r1,r2)
            elif l2>r1:
                low=partx+1
            else:
                high = partx-1
        
        
        return 1.0
