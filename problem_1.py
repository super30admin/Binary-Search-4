# Using Hashmap 
# Time Complexity - O(m+n)
# Space Complexity - O(m+n)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        l1 = len(nums1)
        l2 = len(nums2)
        d = {}
        res = []
        if l1 > l2 : 
            for each in nums2 : 
                if each in d : 

                   d[each] += 1 
                else :
                    d[each] = 1 
            for each in nums1 : 
                if each in d : 
                    res.append(each)
                    d[each] -= 1 
                    
                    if d[each] == 0 : 
                        del d[each]

        else : 
            for each in nums1 : 
                if each in d : 

                   d[each] += 1 
                else :
                    d[each] = 1 
            for each in nums2 : 
                if each in d : 
                    res.append(each)
                    d[each] -= 1 
                    
                    if d[each] == 0 : 
                        del d[each]
                    
                        
                    

        return res
# Using two pointers 
# Time Complexity - O(m+n)
# Space Complexity - O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)
        p1 = 0 
        p2 = 0 
        res = []
        nums1.sort()
        nums2.sort()

        while p1 < m and p2 < n : 
            if nums1[p1] == nums2[p2]: 
                res.append(nums1[p1])
                p1+= 1
                p2 += 1
            elif nums1[p1] < nums2[p2]:
                p1 += 1 
            else : 
                p2 += 1 

        return res 

# Using binary search
# Time Complexity - O(m logn)
# Space Complexity - O(1)

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        l1 = len(nums1)
        l2 = len(nums2)
        nums1.sort()
        nums2.sort()
        res = []
        if l2 < l1 : 
            self.intersect(nums2,nums1)

        left = 0 
        right = l2-1 

        for each in nums1 : 
          idx =  self.binarySearch(left,right,each,nums2)
          if idx != -1:
              res.append(each)
              left = idx + 1

        return res

    def binarySearch(self,left,right,target,nums2): 

        while left <= right: 
            mid = left + (right-left)//2 
            if nums2[mid] == target : 
                if left < mid and nums2[mid] == nums2[mid-1]: 
                    right = mid -1 
                else:
                    return mid
            elif nums2[mid] < target: 
                left = mid + 1 
            else :
                right = mid -1 
        return -1 

        

        

