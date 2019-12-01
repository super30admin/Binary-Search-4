#Leetcode - 4
#optimal sol
#Time - O(logn)
#space - O(1)
#algo


class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        # 1. Declaring variables
        n1 = len(nums1)
        n2 = len(nums2)

        low = 0
        high = n1

        # shorter array is used for binary search partition, or else the code is failing for edge cases.
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)

        # 2. Calculating partitions in list 1 and 2 and splitting the lists accordingly
        while low <= high:
            partitionof_smaller_array = low + (high - low) // 2
            partitionof_larger_array = (n1 + n2 + 1) // 2 - partitionof_smaller_array

            L1 = float("-inf") if partitionof_smaller_array == 0 else nums1[partitionof_smaller_array - 1]
            R1 = float("inf") if partitionof_smaller_array == n1 else nums1[partitionof_smaller_array]
            L2 = float("-inf") if partitionof_larger_array == 0 else nums2[partitionof_larger_array - 1]
            R2 = float("inf") if partitionof_larger_array == n2 else nums2[partitionof_larger_array]

            # 3. Check if the partitions are correct and if not then reiterate and make them right
            if L1 <= R2 and L2 <= R1:  # if this condition satisfies then calculate median
                # length of combined list is even
                if (n1 + n2) % 2 == 0:
                    return (max(L1, L2) + min(R1, R2)) / 2
                else:
                    return max(L1, L2)

            elif L2 > R1:  # if L2 > R1 then move right L2 and left R1
                low = partitionof_smaller_array + 1
            else:  # if L1 > R2 then move right L1 and left R2
                high = partitionof_smaller_array - 1
        return -1
#algo : Brute force: combine both the arrays, sort both the arrays and return middle element if len of total array is odd, else give middle element and its next element

#time - O(m+n*log(m+n))
#space - O(m+n)
#i did not  understnad why my code was not working on leetode
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        nums1.extend(nums2)
        nums = sorted(nums1)

        n = len(nums)
        # print(nums,n)
        if n % 2 == 0:
            # print(nums[(n-1)//2],nums[(n)//2 ])
            # print((float(nums[(n)//2]) + float(nums[(n+1)//2 ])) / float(2))
            return float((nums[(n) // 2] + nums[(n + 1) // 2]) / 2)
        else:
            return nums[n // 2]
        return -1