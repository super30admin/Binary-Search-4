class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        KeyIdea: create a sorted array by merging two given arrays and then commpute median of that
        SC: O(len(nums1)+len(nums2))
        TC : O(max(nums1, nums2))
        """
       
        n1=len(nums1)
        n2=len(nums2)
        
        # 2 pointers
        p1=0
        p2=0
        res=[]
        
        # iterate both pointers by applying condition to get sorted compiled array
        while p1<n1 and p2<n2:
            if nums1[p1]<nums2[p2]:
                res.append(nums1[p1])
                p1+=1
            else:
                res.append(nums2[p2])
                p2+=1
        while p1<n1:
            res.append(nums1[p1])
            p1+=1
        while p2<n2:
            res.append(nums2[p2])
            p2+=1
        
        n=len(res)
        # check if complied array length is even or odd and compute median simultaneously 
        if n%2==0:
            mid= (res[n//2] + res[(n//2)-1]) / 2
            return mid
        else:
            return res[n//2]
            
       
            
    
                
                
        