class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        
        
        def binarySearch(nums,low,high,target):
            while low<=high:
                mid = low + (high-low)//2
                if nums[mid]==target:
                    if mid==low or nums[mid]>nums[mid-1]:
                        return mid
                    else:
                        high=mid-1
​
                elif nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
                
            return -1
        
        
        
        if nums1 is None or nums2 is None or len(nums1)==0 or len(nums2)==0:
            return []
        n1 = len(nums1); n2 = len(nums2)
        if n1>n2:
            return self.intersect(nums2,nums1)
        res=[]
        nums1.sort()
        nums2.sort()
        index=0
        bi=0
        for n in nums1:
            bi = binarySearch(nums2,index,n2-1,n)
            if bi!=-1:
                res.append(n)
                index = bi+1
       
        return res
                
