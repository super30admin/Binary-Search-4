#Approach : Hashmap
#Time complexity : O(m+n) where m is the size of smaller array for storing in hashmap n is the size of the longer array for iterating over the longer array  
#Space complexity : O(m) for storing the smaller array in the hashmap
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=euobyCF1OMQ&ab_channel=%7BS30%7D
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #if the length of the first array is greater then the length of num2 array then we will swap it and apply the function on the smaller array
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        #creating a hash map for storing the unique numbers with the number of times they are present in the smaller array 
        hashmap ={}
        #we will iterate over the nums1 for inserting the key and value pair in the hashmap
        for i in nums1:
            #if number is already present in the hashmap then we will increment the count of the occurance in the hashmap
            hashmap[i] = hashmap.get(i,0) +1
        #creating the list for storing the intersection result
        result =[]
        #iterating over the values of the nums2 array for checking the interstion with nums1
        for i in nums2:
            if i in hashmap:
                result.append(i)
                hashmap[i] = hashmap.get(i) -1
                #if the hashmap[i] value gets 0 then we will remove it from the hashmap
                if hashmap[i] ==0:
                    del hashmap[i]
        return result
                    
