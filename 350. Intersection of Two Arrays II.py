"""
2 pointer solution: Sort both arrays and start by placing pointers at the start of both.
If number at both pointer is equal, add it to the the result list, otherwise move the smaller pointer forward.

TimeComplexity: O(n)
"""
from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1)
        result=[]

        nums1.sort()
        nums2.sort()
        n1=len(nums1)
        n2=len(nums2)

        p1=0
        p2=0

        while p1<n1 and p2<n2 :
            if nums1[p1]==nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1

            elif nums1[p1]<nums2[p2]:
                p1+=1
            else:
                p2+=1

        return result


"""
Hashmap solution: Iterate over the first array and save each number and its occurance/count in a hashmap. 
Iterate over the second array and if element in second array is present in first array then reduce count of that element in hashmap.
Append the element in result list

"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1)

        result=[]
        hashmap={}

        #iterate over 1st array and add num and occurance in hashmap
        for num in nums1:
            if num in hashmap: #if num already present in hashmap, increase the ocurrance count
                hashmap[num]+=1
            else:
                hashmap[num]=1
        print(hashmap)
        #Iterate over the second array and if element in second array is present in first array then reduce count of that element in hashmap. Append the element in result list
        for y in nums2:
            if y in hashmap:
                hashmap[y]-=1
                result.append(y)
                if hashmap[y]==0:
                    del hashmap[y]

        return result



"""
Binary search
"""
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1)
        result=[]

        nums1.sort()
        nums2.sort()
        n1=len(nums1)
        n2=len(nums2)

        low=0
        high=n2-1

        for i in range(n1):
            curr_ptr=nums1[i]
            b_index=self.bs(nums2,low,high,curr_ptr)
            if b_index!=-1:
                result.append(curr_ptr)
                low=b_index+1

        return result


    def bs(self,arr,low,high,target):
        while low<=high:
            mid=low+(high-low)//2
            if arr[mid]==target:
                if mid==low or arr[mid]>arr[mid-1]:
                    return mid
                else:
                    high=mid-1

            elif arr[mid]>target:
                high=mid-1

            else:
                low=mid+1

        return -1
