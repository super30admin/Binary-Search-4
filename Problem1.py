# Time Complexity : O(n log m)
# Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
# 1. The solution uses binary search to find the intersection of two sorted arrays.
# 2. It maintains a pointer to track the position in the second array while iterating through the first array.
# 3. The result is built by checking if elements from the first array exist in the second array using binary search.

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # Function to perform binary search on nums2 to find the index of the target
        def binarySearch(nums,idx,target):
            left=idx
            right=len(nums)-1
            # Perform binary search to find the index of the target in nums2
            while(left<=right):
                mid=left+(right-left)/2
                if nums[mid]<target:
                    left=mid+1
                else:
                    right=mid-1
            return left
        

        n1=len(nums1)
        n2=len(nums2)
        ls=[]
        low=0
        nums1.sort()
        nums2.sort()
        # If either array is empty, return an empty list
        if n1==0 or n2==0:
            return []
        idx=0
        # Iterate through nums1 and use binary search to find elements in nums2
        for i in range(len(nums1)):
            # If the current element is less than the last found element, skip it
            loc=binarySearch(nums2,idx,nums1[i])
            # If the element is found in nums2, add it to the result list and update the index
            if loc<n2 and nums2[loc]==nums1[i]:
                ls.append(nums1[i])
                idx=loc+1
        # Convert the result list to a fixed-size list
        res=[0]*len(ls)
        i=0
        for ele in ls:
            res[i]=ele
            i+=1
            
        return res

        