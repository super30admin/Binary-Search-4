TimeComplexity :O(min(m,n))
SpaceComplexity:O(max(m,n))
Approach:
#Brute force: for each element get count in nums1 and find that ele in nums2 and get count .add min count x elements into ans
#Hashmap : get count of all elements in min nums1 array for each element in nums2 array if found in dict decrese count by 1 and add in ans .if count ==0 then remove form hashmap
  #O(m+n,min(m,n)
#Sorted:If sorted use modified BS where prev element should not be same (check for corner case if mid ==low) if found change new low to mid






class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #use dict key :[freq in  nums1, freq in. nums2 ] return min or use single dict and reduce count
        d=dict()
        for i in nums1:
            if i in d:
                d[i][0]+=1
            else:
                d[i]=[1,0]
        for i in nums2:
            if i in d:
                d[i][1]+=1
        ans=[]
        for i in d:
            for _ in range(min(d[i][0],d[i][1])):
                ans.append(i)
        return ans
        


#Follow up if nums1 and nums2 are sorted

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        def binarySearch(low,high,target,nums):
            while(low<=high):
                mid=(low+high)//2
                print(nums[mid],target,mid)
                if nums[mid]==target and mid!=low and nums[mid-1]!=nums[mid]:
                   
                    return mid
                if nums[mid]==target and mid==low :
                    print("ok")
                    return mid

                if nums[mid]<target:
                    low=mid+1
                else:
                    high =mid-1
            return -1
        if len(nums1)>len(nums2):
            nums1,nums2=nums2,nums1
        #nums1 is small
        ans=[]
        low=0
        for i in range(len(nums1)):
            x=binarySearch(low,len(nums2)-1,nums1[i],nums2)
            if x==-1:
                # print("this is -1")
                # low+=1
                continue
            else:
                low=x+1

                ans.append(nums1[i])
        return ans


        
