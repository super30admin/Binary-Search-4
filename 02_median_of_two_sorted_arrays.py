'''
Approach 1: Binary Search

In this problem we find the smaller array and assign it to one to perform binary search on it

we keep on partitioning the two arrays until we find a partition that stistifes the condition ==> Aleft <= BRight and Bleft <= ARight
Once this is done depending on total number of elements in both the arrays ie odd or even
for odd we return min(ARight, BRight)
and for even we return (max(Aleft,Bleft)+ min(ARight, BRight))/2

TC = O(log(min(m,n))) since we are running binary search on the smaller array
SC = O(m+n) because have used 2 new arrays having reference to original arrays

'''



class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A = nums1
        B = nums2
        # if len(A) == 0:
        #     #odd
        #     if len(B) % 2:
        #         return B[(len(B)-1)//2]
        #     else:
        #         mid = (len(B)-1)//2
        #         return (B[mid] + B[mid + 1]) / 2
        # elif len(B) == 0:
        #     #odd
        #     if len(A) % 2:
        #         return A[(len(A)-1)//2]
        #     else:
        #         mid = (len(A)-1)//2
        #         return (A[mid] + A[mid + 1]) / 2
        
        total = len(A) + len(B)
        half = total // 2
        
        if len(B) < len(A):
            A, B = B, A
        
        l, r = 0, len(A) - 1
       
        while True:
            i = (l+r) // 2 #A
            j = half - i - 2 #B
            
            Aleft = A[i] if i>=0 else float("-infinity")
            ARight = A[i+1] if (i+1)< len(A) else float("infinity")
            Bleft = B[j] if j>=0 else float("-infinity")
            BRight = B[j+1] if (j+1)< len(B) else float("infinity")
            
            #if partition is valid then we can return
            if Aleft <= BRight and Bleft <= ARight:
                #if odd
                if total % 2:
                    return min(ARight, BRight)
                else:
                    return (max(Aleft,Bleft)+ min(ARight, BRight))/2
            elif Aleft > BRight:
                r = i - 1
            else:
                l = i + 1