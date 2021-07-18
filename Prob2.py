class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums1_len = len(nums1)
        nums2_len = len(nums2)
        
        if (nums1_len > nums2_len):
            return self.findMedianSortedArrays(nums2,nums1)
        
        low = 0
        high = nums1_len
        while low<= high:
            partX = low+(high-low)/2
            partY = (nums1_len+nums2_len)/2-partX
            #finding border elements to partition
            if partX == 0:
                l1=-1*float('inf')
            else:
                l1 = nums1[partX-1]
            if partY == 0:
                l2=-1*float('inf')
            else:
                l2 = nums2[partY-1]
            if partX == nums1_len:
                r1=float('inf')
            else:
                r1 = nums1[partX]
            if partY == nums2_len:
                r2=float('inf')
            else:
                r2 = nums2[partY]
            #if partx and party are at the right pos and all elements left are lesser than right, then find median
            if l2<=r1 and l1<=r2:
                if (nums1_len+nums2_len) %2 == 0:
                    return float(max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            if l2>r1:
                low = partX+1
            elif l1>r2:
                high = partX-1
                
            
#         res = nums1+nums2
#         res = sorted(res)
        
#         if len(res)%2 == 0:
#             mid = res[len(res)/2]
#             mid1 = res[len(res)/2 -1]
#             return float((mid+mid1))/2
#         else:
#             return res[len(res)//2]
        
        
        
