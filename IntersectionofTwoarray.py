'''
time complexity: o(nlogn)
space complexity: o(1)
'''
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if len(nums1)==0 and len(nums2)==0: return []
        if len(nums1)>len(nums2): return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        low = 0
        high = len(nums2)-1
        res = []
        for i in range(len(nums1)):
            idx = self.binarySearch(nums2,low,high,nums1[i])
            if(idx !=-1):
                res.append(nums1[i])
                low = idx+1
        return res
    
    def binarySearch(self,nums2,low,high,target):
        while(low<=high):
            mid = low+(high-low)//2
            if(nums2[mid]==target):
                if(mid==low or nums2[mid]>nums2[mid-1]): return mid
                else: high = mid-1
            elif(nums2[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1