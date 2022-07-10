class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # 2 pointers approach
        # TC O(m+n)
        # SC O(m+n)
        
        p1 = p2 = 0
        res = []
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1] <= nums2[p2]:
                res.append(nums1[p1])
                p1 += 1
            else:
                res.append(nums2[p2])
                p2 += 1
        
        #edge cases
        while p1 < len(nums1):
            res.append(nums1[p1])
            p1 += 1
        
        while p2 < len(nums2):
            res.append(nums2[p2])
            p2 += 1
            
        print(res)
        # calculate median and return
        return res[len(res)//2] if len(res) % 2 == 1 else (res[len(res)//2] + res[(len(res)//2) - 1])/2

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # binary search
        # TC O(logn) where n is size of smaller array
        # SC O(1)
        if len(nums1) > len(nums2) : return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = len(nums1)
        n1, n2 = len(nums1), len(nums2)
        avg = (n1+n2)//2
        while low <= high:
            px = low + (high - low) // 2
            py = avg - px
            
            l1 = nums1[px-1] if (px-1) >= 0 else - float("Infinity") # left of px
            l2 = nums2[py-1] if (py-1) >= 0 else - float("Infinity") # left of py
            r1 = nums1[px] if px < n1 else float("Infinity") # at px
            r2 = nums2[py] if py < n2 else float("Infinity") # at py

            if l1 <= r2 and l2 <= r1:
                break
            elif l1 > r2:
                high = px - 1
            else:
                low = px + 1
        
        return min(r1,r2) if (n1+n2) % 2 == 1 else (max(l1,l2) + min(r1,r2)) / 2
                    