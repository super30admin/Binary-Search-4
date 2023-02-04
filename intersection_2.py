# Time Complexity :
# O(N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We store the element of num1 and it's frequency of occurance in a map. We then go through each element in nums2, each time we find that element in the map, we reduce it's frequency until it's 0 and add the element to the return list
#If the element from nums2 does not exist or has a frequency of 0 in the map, we skip it

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        freq_map = {}
        for elem in nums1:
            if elem in freq_map :
                freq_map[elem] += 1
            else :
                freq_map[elem] = 1

        return_result = []
        for elem in nums2 :
            if elem in freq_map and freq_map[elem] > 0 :
                return_result.append(elem)
                freq_map[elem] -= 1

        return return_result
