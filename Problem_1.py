"""
Problem : 1

Time Complexity : 
Bruteforce - O(n+m)
Two Pointers - if array already sorted - O(max(m,n))
if unsorted - O(max(nlogn+n,mlogm+m))
BinarySearch - O(mlogn)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Bruteforce - 
Storing the number of occurences for each element in first array in hashmap
iterating over second array and checking if the number exists in the hashmap, if yes
then decreasing the counter in hashmap to avoid False occurence and adding element to result
reurning result at the end

Two Pointer - 
Sorting both the arrays, initializing two pointers at the start of both the arrays, if numbers matches 
at a index, adding the number in hashmap and incrementing both the pointers, if bigger number found in either
of the array, incrementing the pointer in the array having small number to match the bigger number, and vice versa
returning the result at the end

Binary Search - 
sorting the two arrays
Iterating over the smaller array, doing a binary search of that number's first occurence in 
bigger array, if index found, adding the number to result and changing the search range for the
bigger array to avoid False positives while searching. Returning the result at the end 

"""

# Intersection of Two Arrays II

# Approach - 1
# Bruteforce

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        hmap={}
        result=[]
        # if len(nums1)<len(nums2):
        #     self.intersect(nums2,nums1)
        for i in range(len(nums1)):
            if nums1[i] not in hmap:
                hmap[nums1[i]]=1
            else:
                hmap[nums1[i]]+=1
        
        for i in range(len(nums2)):
            if nums2[i] in hmap and hmap[nums2[i]]>0:
                result.append(nums2[i])
                hmap[nums2[i]]-=1
        return result

# Approach - 2
# Two Pointers

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        nums1.sort()
        nums2.sort()
        l1,l2=0,0
        result=[]
        while l1<len(nums1) and l2<len(nums2):
            if nums1[l1]==nums2[l2]:
                result.append(nums1[l1])
                l1+=1
                l2+=1
            elif nums1[l1]>nums2[l2]:
                l2+=1
            else:
                l1+=1
        return result

# Approach - 3
# Binary Search

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # Approach - 3
        m=len(nums1)
        n=len(nums2)
        if m>n:
            return self.intersect(nums2,nums1)
        
        li=[]
        nums1.sort()
        nums2.sort()
        p1,p2=0,0
        low,high=0,n-1
        for i in range(m):
            target=nums1[i]
            bsIdx=self.binarySearch(nums2,low,high,target)
            if bsIdx!=-1:
                li.append(target)
                low=bsIdx+1
        return li
    def binarySearch(self,nums,low,high,target):
        while low<=high:
            mid=low+(high-low)/2
            if nums[mid]==target:
                if mid==low or nums[mid]!=nums[mid-1]:
                    return mid
                else:
                    high=mid-1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
