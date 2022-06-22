#Time Complexity: O(Nlogn + Mlogm)
#Space Complexity: O(logn+logm) to O(n + m)O
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 and n2 == 0:
            return 0.0
        if nums1 == [] or nums2 == []:
            if nums1 != []:
                if len(nums1) % 2:
                    return nums1[len(nums1)//2]
                else: return (nums1[len(nums1)//2] + nums1[(len(nums1)-1)//2])/2
                
            else:
                if len(nums2) % 2:
                    return nums2[len(nums2)//2]
                else: return (nums2[len(nums2)//2] + nums2[(len(nums2)-1)//2])/2
        if n1 > n2:
            return self.findMedianSortedArrays(nums2,nums1)
        
        low = 0
        high = n1
        while low <= high:
            xrange = (low + high) // 2
            yrange = (n1 + n2)//2 - xrange


            if xrange == 0:
                left1 = float('-inf')
            else:
                left1 = nums1[xrange - 1]
            if xrange == n1:
                right1 = float('inf')
            else:
                right1 = nums1[xrange]

            if yrange == 0:
                left2 = float('-inf')
            else:
                left2 = nums2[yrange - 1]
            if yrange == n2:
                right2 = float('inf')
            else:
                right2 = nums2[yrange]
                
            if(left1<=right2 and left2 <= right1):
                if (n1 + n2)%2 == 0:
                    return (max(left1,left2) + min(right1,right2))/2
                else:
                    return min(right1,right2)
            elif left1 > right2:
                high = xrange - 1
            elif left2 > right1:
                low = xrange + 1
            
        return 8.99
            
        