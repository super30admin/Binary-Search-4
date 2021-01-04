class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        #O(m+n)
#         arr = {}
#         for num in nums1:
#             arr[num]=arr.get(num,0)+1
        
#         res = []
#         for num in nums2:
#             if num in arr and arr[num] != 0:
#                 res.append(num)
#                 arr[num] = arr[num] - 1
#         return res  


#O(NlogM)
#mutating the array by popping
#         def binary_search(num, target):
#             l,h=0,len(num)-1
#             while(l<=h):
#                 m=l+(h-l)//2
#                 if (num[m]==target):
#                     #remove instance of mid 
#                     num.pop(m)
#                     return True
#                 elif (num[m]>target):
#                     h=m-1
#                 elif (num[m]<target):
#                     l=m+1
#             return False

#         nums2.sort()
#         result=[]
        
#         for x in nums1:
#             if (binary_search(nums2,x)==True):
#                 result.append(x)

#         return result

        if len(nums1) > len(nums2): 
            nums1, nums2 = nums2, nums1 
       
        def binarySearch(nums, low, high, target): 
            while low <= high: 
                mid = (low+(high-low)//2) 
                if nums[mid] == target:
                    if low==mid or nums[mid-1]<nums[mid]:
                        return mid
                    else:
                        high = mid-1
                elif nums[mid] > target: 
                    high = mid -1
                else: 
                    low = mid+1 
            return -1

        res = [] 
        nums1.sort()
        nums2.sort()
        low, high = 0, len(nums2)-1
        for i, x in enumerate(nums1): 
            index = binarySearch(nums2, low, high, x)
            if index != -1: 
                #binary search on other half after finding previous intersection
                low = index+1 
                res.append(x)
        return res