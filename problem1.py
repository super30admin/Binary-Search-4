class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if(len(nums2)>len(nums1)):
            return self.intersect(nums2,nums1)
        
        nums1.sort()
        nums2.sort()
        prev = 0
        ans = []
        for i in nums2:
            val = self.binary(nums1,prev,len(nums1)-1,i)
            if(val!=-1):
                ans.append(i)
                prev = val+1
        return ans
    
    def binary(self,nums1,l,h,target):
        while(l<=h):
            mid = (l+h)//2
            if(nums1[mid]==target):
                if(mid==l or nums1[mid-1]!=nums1[mid]):
                    return mid
                else:
                    h = mid-1
            elif(nums1[mid]>target):
                h= mid-1
            else:
                l=mid+1
        return -1
                