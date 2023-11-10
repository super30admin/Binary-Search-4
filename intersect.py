# // Time Complexity :O(mlog(n))
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we do BS on bigger array and go through each elem on smaller arraya dn update the boundaries accordinly
from collections import Counter
class Solution(object):
    def binarySearch(self,arr,low,high,target):
        while(low<=high):
            mid=(high+low)//2
            if(arr[mid]==target):
                if(mid==low or arr[mid-1]<arr[mid]):
                    return mid
                else:
                    high=mid-1
            elif(arr[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1

    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        m=len(nums1)
        n=len(nums2)
        if(m>n):
            return self.intersect(nums2,nums1)
        res = []
        nums1_counter=Counter(nums1)
        nums2_counter=Counter(nums2)
        for num, count in nums1_counter.items():
            common_count = min(count, nums2_counter.get(num, 0))
            res.extend([num] * common_count)

        return res