'''
space complexity: O(1)
time complexity: O(mm+n)
'''
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if(len(nums1)>len(nums2)): return self.findMedianSortedArrays(nums2,nums1)
        
        n = len(nums1)
        m = len(nums2)
        low = 0 
        high = n
        while(low<=high):
            partx = (low+high)//2
            party = (n+m)//2 - partx 
            
            l1 = float('-inf') if partx==0 else nums1[partx-1]
            r1 = float('inf') if partx==n else nums1[partx]
            l2 = float('-inf') if party==0 else nums2[party-1]
            r2 = float('inf') if party==m else nums2[party]
            
            if(l1<=r2 and l2<=r1):
                #partition found
                print(m)
                print(n)
                if(m+n)%2==0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)    
            else:
                if(l2>r1):
                    low = partx+1
                    
                elif(l1>r2):
                    high = partx-1
                    
        return -1