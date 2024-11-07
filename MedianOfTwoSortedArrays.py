#Time Complexity: O(min(n1,n2)) , where n1 and n2 are the lengths of nums1 and nums2. This complexity arises because we perform a binary search on the smaller array, making each step take logarithmic time relative to the smaller array's length.
#Space Complexity: O(1), as we only use a constant amount of additional space for variables like l1, r1, l2, r2, and loop controls without creating additional data structures.
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        #Consider the length of arrays
        n1 = len(nums1)
        n2 = len(nums2)
        #Always the array on which we are taking the first partition should be smaller, As if the second is smaller then it may go out of bounds
        if(n2<n1):
            return self.findMedianSortedArrays(nums2, nums1)
        #Binary Search on nums1
        low = 0
        high = n1
        while(low<=high):
            #Mid is the partition on nums1
            partx = low+(high-low)//2
            #Parition formuale for nums2
            party = ((n1+n2)//2) - partx
            #Choosing l1,l2,r1,r2 for checking if our partition is right and can stop binary search or else continue until we get the proper paritions
            l1 = float('-inf') if partx == 0 else nums1[partx-1]
            r1 = float('inf') if partx == n1 else nums1[partx]
            l2 = float('-inf') if party == 0 else nums2[party-1]
            r2 = float('inf') if party == n2 else nums2[party]
            #Right partion case
            if(l1<=r2 and l2<=r1):
                #If the combined array has even number of elements
                if ((n1+n2)%2 == 0):
                    return ((max(l1,l2)+min(r1,r2))/2.0)
                #If the combined array has odd number of elements
                else:
                    return (min(r1,r2))
            #Wrong partition case:1
            elif(l1>r2):
                high = partx - 1
            #Wrong partition case:2
            else:
                low = partx + 1
            