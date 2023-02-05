# Time Complexity :
# O(log (min(m,n)))

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We are trying the find the partition according to which the combined array will be sorted and that the found partition is next to the centre element
#So we first pick a partition in the first array, then compute the partition of the second array using that (since we need equal number of elements on left and right of the combined list, we can compute this)
#Now, if the left element of the first partition is smaller than the right element of the second partition and vice versa - we are done, this is the parition in the sorted array we were looking for
#If the left element of the first partition is greater than the right element of the second partition, then we move the high (of the binary search) to partition-1 (we know that the partition has to be the left of the current partition)
#If the left element of the second partition is greater than the right element of the first partition, then we move the low (of the binary search) to partition+1 (we know that the partition has to be the right of the current partition)

#Now that we have the partition, if the total number of elements is odd, we just return the min of the two elements right of each of the paritions as we need the center element and the min among them is the center
#If the total number of elements is even, then we pick the max of both the left values, add it to the min of right values, divide this sum by 2 and return.

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        low = 0
        n1 = len(nums1)
        n2 = len(nums2)
        if n1 == 0 and n2 == 0 :
            return 0.0
        else :
            if n1 > n2:
                self.findMedianSortedArrays(nums2,nums1)

        high = n1

        while low <= high :
            partition = low + int((high - low )/2)
            second_partition = int ((n1+n2) / 2)  - partition

            if second_partition > n2:
                low = partition + 1
                continue
            if second_partition < 0 :
                high = partition - 1
                continue

            if partition != 0 :
                l1 = nums1[partition-1]
            else :
                l1 = -10 ** 7
            
            if partition != n1:
                r1 = nums1[partition]
            else :
                r1 = 10 ** 7
                
            if second_partition != 0 :
                l2 = nums2[second_partition-1]
            else :
                l2 =  -10 ** 7
            
            if second_partition != n2:
                r2 = nums2[second_partition]
            else :
                r2 = 10 ** 7

            if l1 <= r2 and l2 <= r1 :
                if (n1 + n2) % 2 == 1 :
                    return min(r1,r2)
                else:
                    return (max(l1,l2) + min(r1,r2))/2

            if l1 < r2 and l2 > r1 :
                low = partition + 1

            if l1 > r2 and l2 < r1 :
                high = partition - 1
                
