#Time Complexity:O(log m(size of greater array))
#Space Complexity:O(1)

class Solution(object):
    def findMedianSortedArrays(self, num1, num2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if len(num1)==0 and len(num2)==0:
            return 0
        m=len(num1)
        n=len(num2)
        if m>n:
            return self.findMedianSortedArrays(num2,num1)
        low=0
        high=m
        while(low<=high):
            partX=(low+high)//2
            partY=((m+n)//2)-partX
            if partX>0:
                l1=num1[partX-1]
            else:
                l1=-999999999
            if partY>0:
                l2=num2[partY-1]
            else:
                l2=-999999999
            if partX<m:
                r1=num1[partX]
            else:
                r1=999999999
            if partY<n:
                r2=num2[partY]
            else:
                r2=999999999
            if l1<=r2 and l2<=r1:
                if (m+n)%2==0:
                    return (max(l1,l2)+min(r2,r1))/2.0
                return min(r1,r2)
            if l1>r2:
                high=partX-1
            else:
                low=partX+1
            
