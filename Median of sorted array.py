# // Time Complexity  : O(log(m)) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# do binary search on partition insted of elements find mid 
# make sure for edge conditions of having mid element at 0 or last
# partX is from small list
# partY is from big list
# partX is mid of the list
# and partY is (n1+n2)//2 - partX
# if l1<=r2 and l2<=r1 then we have made right partition and our median lies at second part
# else do partiotion again by moving low and high accordingly


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        # num1 small and num2 big
        
        if n1>n2: return self.findMedianSortedArrays(nums2, nums1)
        low, high = 0, n1
        while low <= high:
            partX = (low+high)//2
            partY = (n1+n2)//2 -partX
            
            #Upper list (smaller)
            l1 = float('-inf') if partX == 0 else nums1[partX-1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            
            #Lower list (Bigger)
            l2 = float('-inf') if partY == 0 else nums2[partY-1]
            r2 = float('inf') if partY == n2 else nums2[partY]
            
            if l1 <= r2 and l2<= r1:
                #We have found the right median 
                # check if the n1+n2 is Odd or Even 
                # if Even return the max from left and min from right side 
                if (n1+n2)%2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                else:
                    # if odd we return from middle part
                    return min(r1,r2)
            # baclance the partitions accordingly
            elif l1>r2:
                high = partX-1
            else:
                low = partX+1
        return 1.00
        
                