#Time Complexity= O(log n) where n is the size of smaller list
#Space complexity=O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A,B=nums1,nums2
        
        if len(nums1)>len(nums2):
            A,B=B,A

        total=len(A)+len(B)
        half=total//2
        l=0
        h=len(A)-1
        while True:
            i=l+(h-l)//2
            j=half-i-2
            
            Aleft=A[i] if i>=0 else float("-infinity")
            Aright=A[i+1] if i+1<len(A) else float("infinity")
            Bleft=B[j]if j>=0 else float("-infinity")
            Bright=B[j+1] if j+1<len(B) else float("infinity")
            
            if Aleft<=Bright and Bleft<=Aright:
                if total%2:
                    return min(Aright,Bright)
                else:
                    return (max(Aleft,Bleft)+ min(Aright,Bright))/2
            elif Aleft>Bright:
                h=i-1
            else:
                l=i+1
            
