"""
Brute force would be to combine both the arrays and find the center and return the values, TC = O(n1+n2)

Binary Search Approach:

Unique algorithm, not applicable to any other questions
we use the concept of partition of arrays, for 4 elements, we have 4 indices BUT we have 5 partitions

Partitions : depending on partition in X array, we find the partition in Y array such that number of elements to the right side of the
partition are equal to the number of elements in the y partition

BUT in case of odd number of elements :
we cannot split into 2 equal parts, we will have to keep an extra element on one of the sides (one extra on right side in our case)
Yp = (n1+n2)//2 -Xp 

In case of correct partitions, all the elements on the left of the partitions should be less than all the elements on right

We only need to check cross elements i.e. if l1<r2 and l2<r1
as l1<r1 and l2<r2 will always be true

If above check is invalid we will move the partition of the smaller array to the corect direction and find the corresponsding partition in the second array

TC = O(log n1)-where n1 is the number of elements in smaller array
SC = O(1)

as we will always be doing Binary Search on smaller one, for the larger array, we are finding the partition using a formula

"""
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1= len(nums1)
        n2 = len(nums2)
        
        if n1>n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n1 #partitions are 1+indices 
        avg = (n1+n2)//2
        while low<=high:
            px= low+  (high-low)//2
            py= avg -px
            
            if px-1 >=0:
                l1 = nums1[px-1]
            else:
                l1 = float('-inf')
            
            if py-1 >= 0:
                l2 = nums2[py-1]
            else:
                l2 = float('-inf')
                
            if px < n1:
                r1 = nums1[px]
            else:
                r1 = float('inf')
            
            if py < n2:
                r2 = nums2[py]
            else:
                r2 = float('inf')
                
            if  l1 <= r2 and l2 <= r1:
                break
            elif l2>r1:
                low = px+1
                
            else:
                high = px-1
                
                
                
        return min(r1,r2) if (n1+n2) % 2 == 1 else (max(l1,l2) + min(r1,r2)) / 2
                
                
        
        
        
        
        

