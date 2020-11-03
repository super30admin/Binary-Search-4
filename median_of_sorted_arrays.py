class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1)<=len(nums2):
            return self.calculateMedian(nums1,nums2)
        else:
            return self.calculateMedian(nums2,nums1)
        
    def calculateMedian(self,x,y):
        start=0
        end=len(x)
        while start<=end :
            partitionx=(start+end)//2
            partitiony=((len(x)+len(y)+1) //2) - partitionx
            leftx=x[partitionx-1] if partitionx>0 else float("-inf")
            righty=y[partitiony] if partitiony<len(y) else float("inf")
            lefty= y[partitiony-1] if partitiony>0 else float("-inf")
            rightx=x[partitionx] if partitionx<len(x) else float("inf")
            if leftx<=righty and lefty<=rightx:
                if (len(x)+len(y)) % 2 ==0:
                    return (max(leftx,lefty)+min(rightx,righty))/2
                else:
                    return max(leftx,lefty)
            elif leftx >righty:
                end=partitionx-1
            else:
                start=partitionx+1