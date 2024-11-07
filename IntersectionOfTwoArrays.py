#Time Complexity: O(m+n) due to linear traversal of both arrays.
#Space Complexity: O(min(m,n)) due to the hashmap storing the elements of the smaller array and the result list.
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)
        #Consider the smaller array to get the frequency of elements as iterating through it takes less time comparitively 
        if(n2<n1):
            return self.intersect(nums2, nums1)
        hashmap = dict()
        #Iterate through nums1, add the element and it's frequency to hashmap 
        for num in nums1:
            hashmap[num] = hashmap.get(num,0)+1
        result = []
        #Iterate through nums2, check if the element is present in hashmap
        for num in nums2:
            #If it is present and frequency is atleast 1
            if(num in hashmap and hashmap[num]>0):
                #Add it to result list and decrement it's frequency by 1
                result.append(num)
                hashmap[num] -= 1
                #If frequency of any element becomes 0 then remove it from hashmap
                if(hashmap[num]==0):
                    hashmap.pop(num)
        return result