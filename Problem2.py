#Time Complexity :- O(log(m)) where m is the array size which is smaller
#Space Complexity:- O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)

        if n <m:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = m
        while low<=high:
            partX = (low+high)//2
            partY = ((m+n)//2)- partX
           # print("partY", partY)
            l1 = None
            l2 = None
            r1 = None
            r2 = None
            if partX == 0:
                l1 = -math.inf
            else:
                l1 = nums1[partX-1]
            
            if partY == 0:
                l2 = -math.inf
            else:
                print(partY-1)
                l2 = nums2[partY-1]
            
            if partX == m:
                r1 = math.inf
            else:
                r1 = nums1[partX]
            
            if partY == n:
                r2 = math.inf
            else:
                r2 = nums2[partY]
            if l1<=r2 and l2<=r1:
                if (m+n)%2==0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                return min(r1,r2)
            elif l2>r1:
                low = partX +1
            else:
                high = partX-1
        return 0
