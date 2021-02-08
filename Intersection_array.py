# Approach 1: if the arrays are not sorted

#Time: O(m+n)
#Space: O(m) (m < n ) or O(n)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        # Always enurse that the first array will going to have always smaller one.
        # why beacuse we need a lesser space so we are going with smaller one
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        
        result = []
        hashmap = {}
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

# Approach 2: if the arrays are sorted

#Time: O(m+n)
#Space: O(m) (m < n ) or O(n)

class Solution(object):
    def intersect(self, nums1, nums2):
        # ensure nums1 is the smaller array always
        n1 = len(nums1)
        n2 = len(nums2)
        if(n1 < n2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        p1 = 0 
        p2 = 0
        result = []
        while p1 < n1 and p2 < n2:
            if nums1[p1] == nums2[p2]:
                result.append(nums1[p1])
                p1 += 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1
            else:
                p2 += 1
        return result
