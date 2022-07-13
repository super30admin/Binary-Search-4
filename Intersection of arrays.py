#TC:O(m+n) where m and n are the leng of both arrays
#SC:O(m) size of smaller array
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        hashMap=dict()
        li=[]
        def intersection(nums2,nums1):
            for i in range(len(nums2)):
                if nums2[i] in hashMap:
                    hashMap[nums2[i]]+=1
                else:
                    hashMap[nums2[i]]=1
            for j in range(len(nums1)):
                if nums1[j] in hashMap:
                    if hashMap[nums1[j]]>0:
                        hashMap[nums1[j]]-=1
                        li.append(nums1[j])
            return li
        if len(nums1)>len(nums2):
            return intersection(nums2,nums1)
        else:
            return intersection(nums1,nums2)

#code using 2 pointer solution
'''
#TC:O(m+n) where m and n are the leng of both arrays
#SC:O(1)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        m=0
        n=0
        li=[]
        nums1.sort()
        nums2.sort()
        while(m<len(nums2) and n<len(nums1)):
            if nums2[m]==nums1[n]:
                li.append(nums2[m])
                m+=1
                n+=1
            elif nums2[m]<nums1[n]:
                m+=1
            else:
                n+=1
        return li
'''

#code using binary search
'''
    # TC: O(mlog(n)) if sorted
    # SC: O(1)
class Solution:
    def intersect(self, nums1, nums2):
        if len(nums1)>len(nums2): return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        def binarysearch(nums2,l,h,target):
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
            #print(idx)
            if idx!=-1:
                result.append(i)
                l=idx+1
        return result
'''
        
                
                
                