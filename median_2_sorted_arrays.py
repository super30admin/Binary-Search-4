"""
// Time Complexity : O(logn) n is length of shorter array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """
        Idea - current understanding & gaps
        Primarily we have to find the partitions in both the array in such a way that elements to left of partition are less than elements to the right
        - 2 parts to the problem
            - Fixing the right partition
            Running binary on nums1 to set the partition for nums1 (l1,h1)
                -if l2 > r1 , low  = partX + 1
                 if l1 > r2 , high = partX - 1            
            
            - Evaluate the median based on the odd/even elements in nums1 + nums2 and highest element in nums1 and lowest element in nums2 
        
        1 2 3 4 7 8 9 10 11 12 13 15 16
        
        1 2 | 3 4 11 12 13
        7 8 9 10 15 | 16   -> h2 > l2: partx = lo + 1
        
        1 2 3 4 | 11 12 13
        7 8 9   | 10 15 16
        median = max(4,9) = 4 since m + n is odd
        
        1 2
        3 4
        1  2 | -
        -    | 3 4
        median = (max(2,inf) + min(inf, 3)) /2 = (2 + 3) /2 = 2.5
        """
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 > n2: #this is required  because partition is one extra index and if we are running bsearch on larger array, then for shorter array r2 will go out of bounds eg [1,3] [2], party = 1
            return self.findMedianSortedArrays(nums2, nums1)
        low,high = 0 ,n1 #as opposed to n1 - 1
        while low <=high:
            partx = (low + high) // 2

            #setting the partition y index with respect to both the arrays
            party = ((n1 + n2+1) // 2) - partx

            #l1 points to highest element in first half of partitionx
            l1 = float("-inf") if partx == 0 else nums1[partx-1]

            #r1 points to lowest element in second half of partitionx
            r1 = float("inf") if partx == n1 else nums1[partx]

            #l2 points to highest element in first half of partitiony
            l2 = float("-inf") if party == 0 else nums2[party-1]

            #r2 points to lowest element in first half of partitiony
            r2 = float("inf") if party == n2 else nums2[party]
            
            if l1 <= r2 and l2 <= r1: #correct partition
                #compute the median based on odd and even
                n = n1 + n2
                if n % 2:
                    return max(l1,l2)
                else:
                    return (max(l1,l2) + min(r1,r2))/2
            elif l2 > r1: #moving the mid to right so that partitiony pointer moves to left so that chance of elements having smaller values on left greater than right is more (since l2 > r1)
                low = partx + 1
            else:
                #moving the mid to left so that partitiony pointer moves to right and as we move towards increasing order of elements, getting higher element in left from right(since l1 > r2) is beneficial to get the correct partition
                high = partx - 1
        return -1