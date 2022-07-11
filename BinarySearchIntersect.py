#Approach : Binary Search
#Time complexity : O(mlogn) where m is the size of smaller array for iterating over it and logn for doing binary search on the bigger array 
#Space complexity : O(m) for storing the smaller array in the hashmap
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=euobyCF1OMQ&ab_channel=%7BS30%7D
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #if the length of the first array is greater then the length of num2 array then we will swap it and apply the function on the smaller array
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        #sorting two arrays for having modified binary search 
        nums1.sort()
        nums2.sort()
        #definig the low and high pointer for doing binary search on the array with the bigger length
        low = 0
        high = len(nums2)-1
        #defining the result list
        result =[]
        #iterating over the element of smaller array and checking if the element is present in the larger array with the help of binary search
        for i in nums1:
            #we will be storing the middle index or the found element index in mid so that we will start binary search after it
            mid = self.binaryserarch(nums2, i, low, high)
            #if we find the element in the num2 then we will put it in the result array 
            if mid!= -1:
                result.append(i)
                #changing the low pointer after finding the middle element of the found number
                low = mid+1
        return result
    
    def binaryserarch(self, nums2: List[int], i:int, low:int, high:int):
        while low<=high:
            mid = low + (high-low)//2
            #checking if the current middle index num is same as i
            if nums2[mid] == i:
                #checking if the previous number is not same and if it is same then we need to check if the mid is already reached the low for the case that previous i might be encountered and it is same as current i
                if mid == low or nums2[mid] != nums2[mid-1]:
                    return mid
                #if previous number is same and it is still not encountered then we will change high to the mid -1 so that we reach the first occurance of the number
                else:
                    high = mid -1
            #if the i is not found then we will check the mid is less than i and if it is then we will change the low
            elif nums2[mid]<i:
                    low = mid +1
            else:
                high =mid-1
        return -1
