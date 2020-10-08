#Brute Force:

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        
        for i in nums2:
            nums1.append(i)
            
        nums1 = sorted(nums1)
        print(nums1)
        
        mid = (0+len(nums1)-1)//2
        print(mid)
        if len(nums1)%2==0:
            return (nums1[mid]+nums1[mid+1])/2
        else:
            return nums1[mid]
        
