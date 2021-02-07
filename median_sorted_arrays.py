# -*- coding: utf-8 -*-
"""
TC: O(log(m+n)) whre m = length of nums1 and n = length of nums2
SC: O(1) no extra space used
"""

class Solution:
    def findMedianSortedArrays(self, nums1:[], nums2:[]):
        #edge case
       
        n1 = len(nums1)
        n2 = len(nums2)
        total = (n1 + n2)
        half = total //2
        
        if n1 > n2:
            nums1,nums2 = nums2,nums1
        
        #Assign left and right pointer
        l,r = 0, len(nums1)-1
        
        while True:
            i = (l + r) //2
            j = half - i - 2
            
            Aleft = nums1[i] if i >= 0 else float("-infinity")
            Aright = nums1[i+1] if (i+1) < len(nums1) else float("infinity")
            Bleft = nums2[j] if j >= 0 else float("-infinity")
            Bright = nums2[j+1] if (j+1) < len(nums2) else float("infinity")
            
            #partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                
                if total % 2:
                    return min(Aright,Bright)
                else:
                    return (max(Aleft,Bleft) + min(Aright,Bright))/2
                    
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1     
                

        