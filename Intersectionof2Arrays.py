class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """Assuming sorted nums are given
        using modified binary search---first occurence and move index of binary search
        Time complexity-O(nlog(m)) where n is the size of smaller array (we are iteratng over it and doing binary search on second array where num elements are m)
        Space complexity-O(1)"""
        nums1.sort()
        nums2.sort()
        if len(nums1)>len(nums2):
            self.intersect(nums2, nums1)
        start=0
        end=len(nums2)-1
        result=[]
        for i in nums1:
            index=self.binarysearchfirstOccurence(nums2, i, start, end)
            if index!=-1:
                result.append(i)
                start=index+1
        return result
                
            
    def binarysearchfirstOccurence(self, arr, target, start, end):
        while start<=end:
            mid=start+(end-start)//2
            if arr[mid]==target:
                if mid==start or arr[mid]>arr[mid-1]:
                    return mid
                else:
                    end=mid-1
            elif arr[mid]<target:
                start=mid+1
            else:
                end=mid-1
        return -1
        """2 pointers solution
        Time complexity-O(m+n)
        Space complexity-O(1)"""
        # p1=0
        # p2=0
        # nums1.sort()
        # nums2.sort()
        # result=[]
        # while p1<len(nums1) and p2<len(nums2):
        #     if nums1[p1]==nums2[p2]:
        #         result.append(nums1[p1])
        #         p1+=1
        #         p2+=1
        #     elif nums1[p1]<nums2[p2]:
        #         p1+=1
        #     else:
        #         p2+=1
        # return result
        """using hashmap
        Time complexity-O(max(m, n)) as we are iterating over all elements
        Space complexity-O(n) as using hashmap for smaller array"""
        # if len(nums1)>len(nums2):
        #     self.intersect(nums2, nums1)
        # hashmap={}
        # result=[]
        # for i in nums1:
        #     if i not in hashmap:
        #         hashmap[i]=1
        #     else:
        #         hashmap[i]+=1
        # for i in nums2:
        #     if i in hashmap:
        #         result.append(i)
        #         hashmap[i]-=1
        #         if hashmap[i]==0:
        #             hashmap.pop(i)
        # return result
                
            
        