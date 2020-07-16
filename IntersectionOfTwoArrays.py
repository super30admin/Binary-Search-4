--------------------------------Intersection of Two Arrays---------------------------------------------
# Time Complexity : O(max(m,n)) where m is length of nums1, n is length of nums2
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I Here I used a dict to store the frequency of the elements in the array whose length is greater. Then I will iterate
# through small array and check weather that element is present in the dict or not. If yes I will append that element to result and decrement the 
# element count and if it is 0 then delete that number from dict.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if (not nums1 and not nums2) or not nums1 or not nums2:
            return []
        
        if len(nums1)<len(nums2):
            nums1, nums2 = nums2, nums1

        res = []
        d = Counter(nums1)
        for i in nums2:
            if i in d:
                res.append(i)
                d[i]-=1
                if d[i] == 0:
                    del d[i]
                    
        return res
        
 
--------------------------------Intersection of Two Arrays If array is sorted ---------------------------------------------
# Time Complexity : O(m+n) where m is length of nums1, n is length of nums2
# Space Complexity : O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I use 2 pointer approach where i will iterate through arrays with 2 pointers and check if the elements are equal.
# If yes, I will append the element to result and increment both pointers. else if nums1 element is less than nums2 element, then 
# increment only nums1 pointer , else nums2 pointer. 

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if (not nums1 and not nums2) or not nums1 or not nums2:
            return []
        
        i = 0
        j = 0
        temp = []
        nums1.sort()
        nums2.sort()
        while i<len(nums1) and j<len(nums2):
            if nums1[i] == nums2[j]:
                temp.append(nums1[i])
                i +=1
                j +=1
            elif nums1[i]<nums2[j]:
                i +=1
            else:
                j +=1
        
        return temp
        

 
--------------------------------Intersection of Two Arrays If array is sorted (Binary Search)---------------------------------------------
# Time Complexity : O(log(m+n)) where m is length of nums1, n is length of nums2
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I will iterate through the small array and use binary search to find each number in the second array.
# Once I find the number from the second array I will return the index and as the array is sorted, I can exclude all the elements from the array before that index
# and start binary search from the next element in the same array, in which my low pointer moved forward by 1.
       
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if (not nums1 and not nums2) or not nums1 or not nums2:
            return []
        
        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1
            
        nums1.sort()
        nums2.sort()
        def binarysearch(nums, target, low, high):
            while low<=high:
                mid = (low+high)//2
                
                if nums[mid] == target:
                    if mid == low or nums[mid]>nums[mid-1]:
                        return mid
                    else:
                        high = mid-1
                elif nums[mid]>target:
                    high = mid-1
                else:
                    low = mid+1
            return -1

        index = 0
        res = []
        for i in nums1:
            bsIndex = binarysearch(nums2, i, index, len(nums2)-1)
            if bsIndex != -1:
                index = bsIndex+1
                res.append(nums2[bsIndex])
                    
        return res