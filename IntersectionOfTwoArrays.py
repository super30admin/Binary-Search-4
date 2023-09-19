#Time Complexity : O(nlogn)+O(mlogm)+O(mlogn)
#Space Complexity: O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        m = len(nums1)
        n = len(nums2)
        if n<m:
            self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        low = 0
        result = []
        for i in nums1:
            index = self.binarySearch(i,nums2,low,n-1)
            if index!=-1:
                result.append(i)
                low = index+1
        return result

    def binarySearch(self,ele,arr,low,high):
        while low<=high:
            mid = (low+high)//2
            if arr[mid]==ele:
                if mid==low or arr[mid-1]!=ele:
                    return mid
                high = mid-1
            elif  arr[mid]>ele:
                high = mid-1
            else:
                low=mid+1
        return -1
