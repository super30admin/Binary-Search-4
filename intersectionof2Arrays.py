class Solution:
    # sorting & binary search approach
    # TC : O(mlogn)+O(nlogn)
    # SC : O(1)
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def binarySearch(nums,low,high,target):
            while low<=high:
                mid = low+(high-low)//2
                if nums[mid]==target:
                    if mid == low or nums[mid-1] != target:
                        return mid
                    high = mid - 1
                elif nums[mid] < target:
                    
                    low = mid +1
                else:
                    high = mid-1
            return -1
                    
        if nums1 is None or len(nums1) == 0 or nums2 is None or len(nums2)==0:
            return []
        m,n = len(nums1),len(nums2)
        if m > n:
            self.intersect(nums2,nums1)
        hmap = {}
        res = []
        nums1.sort()
        nums2.sort()
        low = 0
        for i in range(m):
            bsindex = binarySearch(nums2,low,n-1,nums1[i])
            if bsindex != -1:
                res.append(nums1[i])
                low = bsindex +1
        return res
