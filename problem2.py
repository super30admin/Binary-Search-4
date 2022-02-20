# Time Compelxity  O(log(min(m, n))
#Space Complexity O(1) constant

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)

        if n1 > n2 :
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n1

        while( low <= high ):
            partX = (low+high)//2 
            partY = (n1 + n2)//2 - partX

            l1 = -100000 if partX==0 else nums1[partX -1]
            r1 = 1000000 if partX==n1 else nums1[partX]

            l2 = -100000 if partY==0 else nums2[partY -1]
            r2 = 1000000 if partY==n2 else nums2[partY]

            if l1<=r2 and l2<=r1:
                if( (n1+n2)% 2 ==0 ):
                    return (max(l1,l2) + min(r2,r1)) /2
                else:
                    return min(r1, r2)
            elif l1 > r2:
                high = partX -1
            elif l2 >r1:
                low = partX + 1

        return 1.0
