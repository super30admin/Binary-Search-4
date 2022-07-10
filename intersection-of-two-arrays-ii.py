# TC: O(m+n)
# SC: O(m), smaller array
class Solution:
    # def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    #     if len(nums1)>len(nums2): return self.intersect(nums2,nums1)
    #     hmap={}
    #     for i in nums1:
    #         if i not in hmap:
    #             hmap[i]=0
    #         hmap[i]+=1
    #     result=[]
    #     for i in nums2:
    #         if i in hmap:
    #             result.append(i)
    #             hmap[i]-=1
    #             if hmap[i]==0:
    #                 del hmap[i]      
    #     return result
    
    # TC: O(m+n) if sorted
    # SC: O(1)
    # def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    #     nums1.sort()
    #     nums2.sort()
    #     l1=0
    #     l2=0
    #     result=[]
    #     while l1<len(nums1) and l2<len(nums2):
    #         if nums1[l1]==nums2[l2]:
    #             result.append(nums1[l1])
    #             l1+=1
    #             l2+=1
    #         elif nums1[l1]<nums2[l2]:
    #             l1+=1
    #         else:
    #             l2+=1
    #     return result
    
    # TC: O(mlog(n)) if sorted
    # SC: O(1)
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2): return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        def binarysearch(nums2:List[int],l:int,h:int,target:int):
            low=l
            high=h
            while low<=high:
                mid=low+(high-low)//2
                if nums2[mid]==target:
                    if mid==low or nums2[mid-1]!=nums2[mid]:
                        return mid
                    else:
                        high=mid-1
                elif nums2[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return -1
        l=0
        h=len(nums2)-1
        result=[]
        for i in nums1:
            idx=binarysearch(nums2,l,h,i)
            print(idx)
            if idx!=-1:
                result.append(i)
                l=idx+1
        return result
            
            
        