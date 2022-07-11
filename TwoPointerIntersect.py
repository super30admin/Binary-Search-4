#Approach : Two Pointer
#Time complexity : O(m+n) where m is the size of smaller array and n is the size of the longer array 
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=euobyCF1OMQ&ab_channel=%7BS30%7D
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #if the length of the first array is greater then the length of num2 array then we will swap it and apply the function on the smaller array
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        #sorting two arrays for having two pointer solution
        nums1.sort()
        nums2.sort()
        #creating the result array 
        result = []
        #starting  with from the first element
        p1 = 0
        p2 = 0
        #iterating over the loop till any one array is traversed
        while p1<len(nums1) and p2<len(nums2):
            #checking if the two numbers are equal or not if equal then we will append that number to the result
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1
            #we will move the smaller corresponding element by 1 if the elements are not equal
            elif nums1[p1]<nums2[p2]:
                #if the nums1 pointer has the less element than we will increament the p1 pointer
                p1+=1
            else:
                p2+=1
        return result
