# Leetcode excution: YES
# time complexity: O(log m+n)
# space complexity: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: list, nums2: list) -> float:
        m=len(nums1) 
        n=len(nums2)
              
        if m > n:
            return self.findMedianSortedArrays(nums2,nums1)
        total=m+n
        mid=total//2
        low=0
        high=len(nums1)-1
        # we know that we will be finding an answer so we loop infinitely  
        while True:
            i=(low+high)//2
            j=(mid-i-2)
            # we assign infinity values if we could have a vlue in the left side or right side
            leftpart1=nums1[i] if i>=0 else float("-infinity")
            leftpart2=nums2[j] if j>=0 else float("-infinity")
            rightpart1=nums1[i+1] if (i+1)<len(nums1) else float("infinity")
            rightpart2=nums2[j+1] if (j+1)<len(nums2)  else float("infinity")
            # if the coniditon we made satisfies then we check if the numbers we have are even or odd
            # if odd we just do min from the right half
            # else we do max from left half then min from right half then we do median on it and return the value 
            if (leftpart1<=rightpart2 and rightpart1>=leftpart2):
                if (total%2)==0:
                    return (max(leftpart1,leftpart2)+min(rightpart1,rightpart2))/2
                return min(rightpart1,rightpart2)
            elif leftpart1>rightpart2:
                high=i-1
            else:
                low=i+1

