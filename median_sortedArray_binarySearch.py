class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        KeyIdea: Partition the both the list such as half number of element in left and right side. Apply binary search on smallar size list while checking conditions
        SC: O(1), creating imaginary combined array
        TC : O(nlogn), n=len(smallar list)
        """
        if len(nums1)>len(nums2):
            return self.findMedianSortedArrays(nums2, nums1)
       
        n1=len(nums1)
        n2=len(nums2)
      
        
        low=0
        high=n1    # since partition can be from 1 to inclusive n
        while low<=high:
            mid = low + (high-low)//2
            partnX = mid
            partnY = (n1+n2)//2 - partnX
            
            # all left side elements are in second list
            if partnX==0:
                l1=float('-inf')
            else: l1=nums1[partnX-1]
            
            # all left side elements are in first list
            if partnX==n1:
                r1=float('inf')
            else: r1=nums1[partnX]
            
            if partnY==0:
                l2=float('-inf')
            else: l2=nums2[partnY-1]
            
            if partnY==n2:
                r2=float('inf')
            else: r2=nums2[partnY]
            
            if l1<=r2 and l2<=r1:
                # correct partition.find median
                if (n1+n2) % 2 ==0:
                    return (max(l1,l2) + min(r1,r2))/2
                else: return min(r1,r2)
            
            # move towards right
            elif l2>r1:
                low=partnX+1
            # move towards left
            else:
                high=partnX-1
        return 0
            
            
                
            
    