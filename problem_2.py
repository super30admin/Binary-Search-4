# Two pointer solution 
# Time complexity - O(m+n)
# Space Complexity - O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        p1 = 0 
        p2 = 0
        l1 = len(nums1)
        l2 = len(nums2)
        res = []
        
        while p1 < l1 and p2 < l2 : 
            if nums1[p1] < nums2[p2] : 
                res.append(nums1[p1]) 
                p1+= 1 
            else : 
                res.append(nums2[p2]) 
                p2+= 1 
        while p1 < l1:
            res.append(nums1[p1])
            p1 += 1

      
        while p2 < l2:
            res.append(nums2[p2])
            p2 += 1

        print(res)
        n = len(res)
        mid = n // 2
        if n % 2 == 0:
            return (res[mid-1] + res[mid]) / 2.0
        else:
            return res[mid] 



# Binary search solution 
# Time complexity - O(log(m+n))
# Space Complexity - O(1)

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        
        if n1 == 0 and n2 == 0:
            return 0.0  
        if n1 > n2 : 
            return self.findMedianSortedArrays(nums2, nums1) 
          
        left = 0 
        right = n1 
        while left <= right : 
            partx = left + (right - left) // 2 
            party = (n1 + n2) // 2 - partx        
            L1 = nums1[partx - 1] if partx > 0 else float('-inf')
            L2 = nums2[party - 1] if party > 0 else float('-inf')
            R1 = nums1[partx] if partx < n1 else float('inf')
            R2 = nums2[party] if party < n2 else float('inf')
      
            if L2 > R1: 
                left = partx + 1
            elif L1 > R2:
                right = partx - 1
            else:             
                if (n1 + n2) % 2 == 0: 
                    return (max(L1,L2) + min(R1,R2)) / 2.0 
                else: 
                    return min(R1,R2)
        
       
        return 1111756489

