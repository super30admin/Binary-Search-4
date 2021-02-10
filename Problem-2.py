#Time Complexity :O(log min(m,n))
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if(len(nums1)>len(nums2)):
            return self.findMedianSortedArrays(nums2,nums1)
        n1=len(nums1)
        n2=len(nums2)
        low=0
        high=n1
        
        while(low<=high):
            xpar=low+(high-low)//2
            ypar=((n1+n2)//2)-xpar

            l1 = -1*sys.maxsize if xpar==0 else nums1[xpar-1]
            r1 = sys.maxsize if xpar==n1 else nums1[xpar]
            l2 = -1*sys.maxsize if ypar==0 else nums2[ypar-1]
            r2 = sys.maxsize if ypar==n2 else nums2[ypar]
            
            if(l1<=r2 and l2<=r1):
                #correct partions
                #Even count of numbers
                if((n1+n2)%2==0):
                    res=(max(l1,l2)+min(r1,r2))/float(2)
                    return res
                #odd count return min btwn r1,r2
                else:
                    res=min(r1,r2)
                    return res
            elif(l2>r1):
                low=xpar+1
            else:
                high=xpar-1
            
        