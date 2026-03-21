# problem 1 

# https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)
        m = len(nums2)

        if m > n:
            return self.intersect(nums2,nums1)

        nums1.sort()
        nums2.sort()
        low = 0 
        high = m-1
        result = []
        for num in nums1:
            searchIdx = self.bs(nums2,low,high,num)
            if searchIdx != -1:
                result.append(num)
                low = searchIdx+1
        return(result)

    def bs(self,ip_arr,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2
            if ip_arr[mid] == target:
                if mid == low or ip_arr[mid] != ip_arr[mid-1]:
                    return mid 
                else:
                    high = mid-1
            elif target > ip_arr[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1