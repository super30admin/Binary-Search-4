class Solution:
    # M is length of nums1, N is length of nums2
    # Time Complexity - O(max(M, N))
    # Space Complexity - O(M+N)
    def findMedianSortedArrays1(self, nums1, nums2):
        pointer1 = 0
        pointer2 = 0
        n1 = len(nums1)
        n2 = len(nums2)
        array = []
        while pointer1 < n1 and pointer2 < n2:
            temp1 = nums1[pointer1]
            temp2 = nums2[pointer2]
            if temp1 <= temp2:
                array.append(temp1)
                pointer1 += 1
            else:
                array.append(temp2)
                pointer2 += 1
        while pointer1 < n1:
            array.append(nums1[pointer1])
            pointer1 += 1
        while pointer2 < n2: 
            array.append(nums2[pointer2])
            pointer2 += 1
        mid = len(array) // 2
        if len(array) % 2 == 0:
            return (array[mid] + array[mid-1]) / 2
        else:
            return array[mid]
    
    # Solution 2 - Using partitioning method
    # M is length of nums1, N is length of nums2
    # Time Complexity - O(min(M, N))
    # Space Complexity - O(1)
    def findMedianSortedArrays2(self, nums1, nums2):
        if len(nums1) <= len(nums2):
            res = self.helper2(nums1, nums2)
        else:
            res = self.helper2(nums2, nums1)
        return res
    def helper2(self, n1, n2):
        k1 = len(n1)
        k2 = len(n2)
        start = 0
        end = len(n1)
        while start <= end:
            p1 = (start + end) // 2
            p2 = (k1 + k2 + 1) // 2 - p1
            l1 = n1[p1 - 1] if p1 > 0 else float("-inf")
            r1 = n1[p1] if p1 < k1 else float("inf")
            
            l2 = n2[p2 - 1] if p2 > 0 else float("-inf")
            r2 = n2[p2] if p2 < k2 else float("inf")
            
            if l1 <= r2 and l2 <= r1:
                total = k1 + k2
                if total % 2 == 0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                else:
                    return max(l2, l1)
            elif l1 > r2:
                end = p1 - 1
            else:
                start = p1 + 1
            
            
            
            

        
                 