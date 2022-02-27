# time complexity : O(n)
# space complexity : O(1)
# runs on leetcode : YES
# any problem faced : No
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            return self.intersect(nums2, nums1)
        
        nums_hash=defaultdict(int)
        for i in nums1:
            nums_hash[i]+=1    
        k=0
        for i in nums2:
            if i in nums_hash and nums_hash[i]>0:
                nums1[k]=i
                nums_hash[i]-=1
                k+=1
    
        return nums1[:k]
        