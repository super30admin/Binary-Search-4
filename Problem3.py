# Time Complexity : O(log(n)) where n is the length of smaller array.
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        low = 0 
        high = n1 
        while low <= high:
            partX = (low+high)//2
            partY = (n1+n2+1) // 2 - partX
            l1 = float('-inf') if partX == 0 else nums1[partX-1]
            R1 = float('inf') if partX == n1 else nums1[partX]
            l2 = float('-inf') if partY == 0 else nums2[partY-1]
            R2 = float('inf') if partY == n2 else nums2[partY]
            if (l1 <= R2 and l2 <= R1):
                # correct partition 
                if (n1+n2) % 2 == 0: # even case 
                    return (max(l1, l2) + min(R1, R2)) / 2 
                else:
                    return max(l1, l2)
            
            elif l1 > R2:
                high = partX - 1 
            
            else:
                low = partX + 1 
        
        return -1 

if __name__ == "__main__":
    s = Solution()
    # Test Case 1
    nums1 = [0,0]
    nums2 = [0,0]
    res = s.findMedianSortedArrays(nums1, nums2)
    print(res)
