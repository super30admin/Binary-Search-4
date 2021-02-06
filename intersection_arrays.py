# Approach 1 - Store the smaller array's frequency of numbers and iterate over the longer array
# everytime the value matches that in dict, add to result and decrement the count, if count  in dict is 0, this has already been recorded in result
# remove from hashmap

# Time - O(M + N) iterating over two arrays
# Space - O(N) for hashmap

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        result = []
        hashmap = {}
        
        if not nums1 or len(nums1) == 0 or not nums2 or len(nums2) == 0:
            return result
        
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        
        # store counts for smaller array
        for num in nums1:
            if num not in hashmap:
                hashmap[num] = 1
            else:
                hashmap[num] += 1
                
                
        for num in nums2:
            if num in hashmap:
                result.append(num)
                hashmap[num] -= 1
                if hashmap[num] == 0:
                    del hashmap[num]
                    
        return result