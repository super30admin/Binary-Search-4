#Space: O(1)
#Time: O(log(size of smaller array))
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n= len(nums1)
        m= len(nums2)
        low=0
        high= n

        if m<n:
            return self.findMedianSortedArrays(nums2, nums1)

        while low <= high:
            partx= int(low + (high-low)/2)
            party = int((n+m)/2) - partx
            if partx != 0:
                l1= nums1[partx-1]
            else:
                l1 = float('-inf')
            if partx != n:
                r1=nums1[partx]
            else:
                r1 = float('+inf')

            if party != 0:
                l2= nums2[party-1]
            else:
                l2 = float('-inf')
            if party != m:
                r2=nums2[party]
            else:
                r2 = float('+inf')

            if l1 <= r2 and l2 <=r1:
                if (m+n)%2==0:
                    return (min(r1,r2)+ max(l1,l2))/2
                else:
                    return min(r1,r2)
            elif(l1 >r2):
                high= partx -1
            elif(l2 >r1):
                low= partx+1
        return 0.00
