## Problem2
# Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

# Method-1: Using two pointers to merge two sorted arrays into one combined sorted, then finding the median
# nums1.length == m
# nums2.length == n
# Time Complexity : O(m + n)
# Space Complexity : O(m + n)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we use two pointers to merge two sorted arrays into one combined sorted array. Depending on the length of the combined 
# sorted array, we return the median. For odd length we have exactly one middle element. For even length we take the average of the
# two middle elements

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # merge two arrays using two pointers with extra space
        merged = []
        i = 0
        j = 0
        while((i < len(nums1)) and (j < len(nums2))):
            if(nums1[i] < nums2[j]):
                # first array element is smaller
                merged.append(nums1[i])
                i += 1
            elif(nums1[i] > nums2[j]):
                # second array element is smaller
                merged.append(nums2[j])
                j += 1
            else:
                # both array elements are equal
                merged.append(nums1[i])
                i += 1
                merged.append(nums2[j])
                j += 1

        while(i < len(nums1)):
            merged.append(nums1[i])
            i += 1

        while(j < len(nums2)):
            merged.append(nums2[j])
            j += 1

        if(len(merged) % 2 != 0):
            # odd length array
            return merged[len(merged) // 2]

        else:
            # even length array
            return ((merged[len(merged) // 2] + merged[(len(merged) // 2) - 1]) / 2.00)
        
sol = Solution()
print("Method-1: Using two pointers to merge two sorted arrays into one combined sorted, then finding the median")
print(sol.findMedianSortedArrays([1,3], [2]))
print(sol.findMedianSortedArrays([1,2], [3,4]))
print(sol.findMedianSortedArrays([0,0], [0,0]))
print(sol.findMedianSortedArrays([1], []))

# Method-2: Optimizing the two pointer approach, without actually merging the arrays
# Time Complexity : O((m + n) / 2) = O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This is an optimized version of the above approach. Here we do not actually merge the two arrays.
# We use two pointers to iterate over the two soretd arrays while keeping track of the two middle elements using curr and prev
# Here we stop our loop once we reach the middle.


class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        totalLen = (len(nums1) + len(nums2))
        mid = totalLen // 2
        
        i = 0
        j = 0
        # to keep track of middle
        count = 0
        prev = 0
        curr = 0
        # loop upto the middle element only
        while(count <= mid):
            prev = curr
            if((i < len(nums1)) and (j < len(nums2))):
                # both pointers in range
                # compare them
                if(nums1[i] <= nums2[j]):
                    curr = nums1[i]
                    i += 1
                else:
                    curr = nums2[j]
                    j += 1
            elif(i < len(nums1)):
                # nums1 elements exist
                curr = nums1[i]
                i += 1
            elif(j < len(nums2)):
                # nums2 elements exist
                curr = nums2[j]
                j += 1
            
            count += 1

        if(totalLen % 2 != 0):
            # total odd number of elements
            return curr
        else:
            # total even number of elements
            return ((prev + curr) / 2.00)
                
sol = Solution()
print("Method-2: Optimizing the two pointer approach, without actually merging the arrays")
print(sol.findMedianSortedArrays([1,3], [2]))
print(sol.findMedianSortedArrays([1,2], [3,4]))
print(sol.findMedianSortedArrays([0,0], [0,0]))
print(sol.findMedianSortedArrays([1], []))


# Method-3: Using Binary Search on partitions of the smaller length array
# Time Complexity : O(Log(min(m,n)))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we use binary search on the partitions of the smaller length array. From this partition of nums1, we find the partition in 
# nums2. Then we check if this is a valid partition of elements where all elements on the left side of the partition are smaller or
# equal to all the elements on the right side of the partition. Here to compare the left side with the right side we do not need to 
# compare all the elements. Just largest of left partition from nums1 should be smaller than smallest of right 
# partition from nums2. If this holds true then all elements smaller than largest of left partition from nums1 would be less than all
# elements greater than or equal to smallest of right partition from nums2. Another case to check is largest of left partition 
# from nums2 should be smaller than smallest of right partition from nums1. If we find the partition where these both conditions
# hold true, that is our valid partition. We return the median based on total elements are odd or even. For odd case, we would have
# one extra element on the right side so our median would be the min(R1, R2). For even case, we would have equal elements on both 
# left and right side. So median in this case would be average of max(L1, L2) and min(R1, R2).

class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        if(len(nums2) < len(nums1)):
            return self.findMedianSortedArrays(nums2, nums1)

        # we do binary search on the partitions of the smaller length array
        low = 0
        # index of last partition = len(nums1) + 1(num of partitions) - 1(index) = len(nums1)
        high = len(nums1)
        n1 = len(nums1)
        n2 = len(nums2)

        while(low <= high):
            # partition on nums1
            partX = low + ((high - low) // 2)
            # corresponding partition on nums2
            partY = ((n1 + n2) // 2) - partX
            # we need to check if all elements on the left side are less than
            # all elements on the right side
            # we just need to cross check, no need to compare elements from the same array
            L1 = float('-inf')
            R1 = float('inf')
            L2 = float('-inf')
            R2 = float('inf')
            if(partX > 0):
                L1 = nums1[partX - 1]

            if(partX < len(nums1)):
                R1 = nums1[partX]

            if(partY > 0):
                L2 = nums2[partY - 1]

            if(partY < len(nums2)):
                R2 = nums2[partY]
            
            if(L2 > R1):
                # element on the left of partition from nums2 is greater than right from nums1
                # incorrect case
                # so partY should move towards left
                # partX should move towards right as they are complement
                # mid should move towards right
                low = partX + 1
            elif(L1 > R2):
                # element on the left of partition from nums1 is greater than right from nums2
                # incorrect case
                # so partX should move towards left
                # mid should move towards left
                high = partX - 1
            else:
                # R1 >= L2 and R2 >= L1
                # we got the correct partition
                if((n1 + n2) % 2 != 0):
                    # total elements are odd
                    # our right side of the partition would have one extra element
                    # so element just to the right of partition in combined sorted array would be our median
                    # median = min(R1, R2)
                    return min(R1, R2)
                else:
                    # total elements are even
                    # our right side and left side of the partition would have equal elements
                    # so average of elements just to the left and just to right of partition in combined sorted array would be our median
                    # median = (max(L1, L2) + min(R1, R2)) / 2.00
                    return (max(L1, L2) + min(R1, R2)) / 2.00


        return -1
    
sol = Solution()
print("Method-3: Using Binary Search on partitions of the smaller length array")
print(sol.findMedianSortedArrays([1,3], [2]))
print(sol.findMedianSortedArrays([1,2], [3,4]))
print(sol.findMedianSortedArrays([0,0], [0,0]))
print(sol.findMedianSortedArrays([1], []))

