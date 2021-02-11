#Time Complexity:O(n1+n2)
#space complexity:O(1)

#approach: place two pointers at the beginning of both arrays after sorting both the arrays. Move the pointers when the elements match after appending to result array,else move pointer that points at lower element
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)==0 or len(nums2)==0:
            return []
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        result=[]
        p1=p2=0
        while(p1<n1 and p2<n2):
            if nums1[p1]==nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1]<nums2[p2]:
                p1+=1
            else:
                p2+=1
        return result


#Time Complexity:O(n1)
#space complexity:O(1)
#approach:Use binary search on one of the arrays to find each element in the other array, if found append to result 
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)==0 or len(nums2)==0:
            return []
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        result=[]
        low=0
        for i in range(n1):
            bsI=self.binarysearch(nums2,nums1[i],low,n2-1)
            if bsI!=-1:
                result.append(nums1[i])
                low=bsI+1
        return result
    
    def binarysearch(self,nums:List[int],target:int,low:int,high:int)->int:
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==low or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    high=mid-1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1