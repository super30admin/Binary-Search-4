#  https://leetcode.com/problems/intersection-of-two-arrays-ii/


################### Hash Map #########################
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hm1 = {}
        for i in range(len(nums1)): # O(m)
            if nums1[i] not in hm1:
                hm1[nums1[i]] = 1
            else:
                hm1[nums1[i]] += 1

        ans = []
        
        for i in range(len(nums2)): 
            if nums2[i] in hm1 and hm1[nums2[i]] > 0:
                hm1[nums2[i]] -=1
                ans.append(nums2[i])
            if nums2[i] in hm1 and hm1[nums2[i]] == 0:
                del hm1[nums2[i]]

        return ans       
    
# TC: O(m + n)
# SC: O(len(intersection))
    
#------------------- Binary Search #########################

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()  # mlogm
        nums2.sort()  # nlogn
        res = []
        index = 0

        for i in range(len(nums1)):
            ind = self.binarysearch(nums2,index,nums1[i])
            if(ind < len(nums2) and nums2[ind] == nums1[i]):
                res.append(nums1[i])
                index = ind + 1
        
        return res
    
    def binarysearch(self,nums2,index,target):
        low = index
        high = len(nums2) - 1

        while low <= high:
            mid = low + (high - low)//2
            '''
            if(nums2[mid] == target):
                return mid
            '''
            if nums2[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
            
        return low

# TC: O(m logn)
# SC: O(len(intersection))

########################### 2 pointers #########################
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()  # mlogm
        nums2.sort()  # nlogn
        res = []
        p1 = 0
        p2 = 0

        while p1<len(nums1) and p2 < len(nums2):
            if nums1[p1] == nums2[p2]:
                res.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1] > nums2[p2]:
                p2+=1
            else:
                p1+=1
        return res

# TC: O(m logm) if m > n => this is for sorting
# SC: O(len(intersection))