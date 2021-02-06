# Approach 1 - Use hashmap
# Store the smaller array's frequency of numbers and iterate over the longer array
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



# Approach 2: Use 2 pointers
# First sort both the arrays - in question assumed it is sorted, so not considered in time complexity
# Time - O(M + N)
# Space - O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        result = []
        
        if not nums1 or len(nums1) == 0 or not nums2 or len(nums2) == 0:
            return result
        
        nums1.sort()
        nums2.sort()
        n1 = n2 = 0
        
        while n1 < len(nums1) and n2 < len(nums2):
            
            if nums1[n1] == nums2[n2]:
                result.append(nums1[n1])
                n1 += 1
                n2 += 1
                
            elif nums1[n1] < nums2[n2]:
                n1 += 1
                
            else:
                n2 += 1
                
        return result