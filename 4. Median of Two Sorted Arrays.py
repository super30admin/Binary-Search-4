# time complexity: O(log(min(m, n)))
# space complexity: O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)==0 and len(nums2)==0: return 0
        
        len1=len(nums1)
        len2=len(nums2)
        
        if len2<len1:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low=0
        high=len1
        while(low<=high):
            partx=int((low+high)/2)
            party=int((len1+len2)/2)-partx
            
            if partx==0:
                l1=-math.inf
            else:
                l1=nums1[partx-1]
            
            if partx==len1:
                r1=math.inf
            else:
                r1=nums1[partx]
            
            if party==0:
                l2=-math.inf
            else:
                l2=nums2[party-1]
                
            if party==len2:
                r2=math.inf
            else:
                r2=nums2[party]
                
            print(l1, l2, r1, r2)
            
            if l1<=r2 and l2<=r1:
                if (len1+len2)%2==0:
                    return (max(l1, l2)+min(r1, r2))/2
                else:
                    return min(r1, r2)
                
            elif l1>r2:
                high=partx-1
            else:
                low=partx+1
                
        return -1
        