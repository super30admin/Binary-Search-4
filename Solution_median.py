"""
TC is Log M where M is length of list on which the biunary search is done

"""
class Solution_median:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if(nums1==0 or nums2==0 or nums1 is None or nums2 is None):
            return 0.00
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.findMedianSortedArrays(nums2,nums1)
        low=0
        high=n1
        while(low<=high):
            partX=low+(high-low)//2
            partY=((n1+n2)//2)-partX
            l1=nums1[partX-1] if partX!=0 else float('-inf')
            r1=nums1[partX] if partX!=n1 else float('inf')
            l2=nums2[partY-1] if partY!=0 else float('-inf') 
            r2=nums2[partY] if partY!=n2 else float('inf') 
        
            if(l1<=r2 and l2<=r1):
                if((n1+n2)%2==0):
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif(l2>r1):
                low=partX+1
            else:
                high=partX-1
            
       
        
            
        