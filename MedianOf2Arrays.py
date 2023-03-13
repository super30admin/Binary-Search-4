#All TC on leetcode passed


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        #Here we use binary search to divide the array into halves.
        #Time complexity - log(m) where m is length of shorter array
        #Space compexity - O(1) 

        
        #swapping to perform B.S. on shorter array
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1

        m = len(nums1)
        n = len(nums2)

        l = 0
        h = m-1

        while True:

            mid1 = (l+h)//2
            mid2 = ((m+n)//2) - (mid1+1) -1 #gives mid2 idx in nums2

            l1 = nums1[mid1] if mid1>=0 else -math.inf
            r1 = nums1[mid1+1] if (mid1+1)<m else math.inf
            l2 = nums2[mid2] if mid2>=0 else -math.inf
            r2 = nums2[mid2+1] if (mid2+1)<n else math.inf

            if l1<=r2 and l2<=r1:
                if ((m+n)%2==0):
                    return (max(l1, l2) + min(r1, r2))/2
                else:
                    return min(r1, r2)        
            elif l1>r2:
                h = mid1-1
            else:
                l = mid1+1

        return -1


       
      
       