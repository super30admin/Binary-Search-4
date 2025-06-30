# TC: O(log(min(n,m)))
# SC: O(1)
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        l1, l2 = len(nums1), len(nums2)
        
        # s = smaller array, b = bigger array
        if l1 < l2:
            s, b = nums1, nums2
        else:
            s, b = nums2, nums1
            l1, l2 = l2, l1  
        
        low, high = 0, l1
        
        while low <= high:
            x_part = (low + high)//2
            y_part = (l1 + l2)//2 - x_part
            
            xleft = float('-inf') if x_part == 0 else s[x_part - 1]
            xright = float('inf') if x_part == l1 else s[x_part]
            
            yleft = float('-inf') if y_part == 0 else b[y_part - 1]
            yright = float('inf') if y_part == l2 else b[y_part]
            
            if xleft <= yright and yleft <= xright:
                if (l1 + l2) % 2 == 0:
                    return (max(xleft, yleft) + min(xright, yright)) / 2
                else:
                    return min(xright, yright)
            elif xleft > yright:
                high = x_part - 1
            else:
                low = x_part + 1
