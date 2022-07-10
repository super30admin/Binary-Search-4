#Time complexity : O(logn) where n is the size of the samllest array 
#Space complexity : O(1) 
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=gmLBi4J906A&ab_channel=%7BS30%7D
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #checking the null condition
        if len(nums1)== 0 and len(nums2)==0:
            return 0.0
        #checking the size of the two array and we will take binary search on the samllest array
        n1 = len(nums1)
        print("n1", n1)
        n2 = len(nums2)
        print("n2", n2)
        #if the length of nums2 is more than the length of n1 then we will call this function again by swaping nums1 with nums2
        if n1>n2:
            #print("n1>n2")
            return self.findMedianSortedArrays(nums2, nums1)
            #nums2, nums1 = nums1, nums2
        #assigning the low and high pointer to the smaller array i.e considering it is nums1
        low = 0
        #we are doing the binary search on the partitions instead of the elements and so we are taking it as n1 instead of n1-1
        high = n1
        #performing the binary search
        while low <= high:
            #taking the partition of n1 as px
            print("low", low)
            print("high", high)
            px = low+ (high-low)//2 
            #taking the partition of n2 as py
            py = (n1 + n2)//2 - px
            #thinking of the imaginary combined array
            # l1 | r1
            # l2 | r2
            #if partition is at index 0 so it means that there is no element on the left side
            #else for the other index should be -1
            if px<= 0:
                l1 = float('-inf')
            else:
                i = px-1
                l1 = nums1[i]
            #l1 = float('-inf') if px == 0 else nums1[px-1]
            l2 = float('-inf') if py == 0 else nums2[py-1]
            #at the right side have no element then put largest element 
            r1 = float('inf') if px == n1 else nums1[px]
            r2 = float('inf') if py == n2 else nums2[py]
            #now calculating the mean
            #checking the cross condition of valid partition
            if l1<=r2 and l2<=r1:
                #if both the condition get satisfied then we will calculate the mean
                #for even total number of elements
                if (n1+n2)% 2 == 0:
                    return (min(r1,r2)+max(l1,l2))/2
                #for odd and we are taking one element less on the left hand side
                else:
                    return min(r1,r2)
            #if the partition conditions are not valid
            elif l2>r1:
                #changing the low if r1 is small
                low = px+1
            else:
                #chanigng the high if r2 is small
                high = px -1
        return 0
