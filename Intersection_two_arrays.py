// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach.
we used a dictionary to keep track of the frequency of elements in the first array and from the second array if element is found in dictionary then we decrement the frequency count of that element and add it to a out array,which we are going to return. 
#using hashmap
# Time complexity --> o(m+n)
# space complexity --> o(dictionary size)+o(out array length)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        out=[]
        if len(nums1)>=len(nums2):
            a=nums1
            b=nums2
        else:
            a=nums2
            b=nums1
        d=dict()
        for i in a:
            if i not in d:
                d[i]=1
            else:
                d[i]=d[i]+1
        for i in b:
            if i in d:
                if d[i]==0:
                    del d[i]
                    continue
                d[i]=d[i]-1
                out.append(i)
        return out



// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach.
we sort both the arrays first and we start from the end of both the arrays.if element at the index we add it to the output which we want to return else we decrement the array index which is having more value.In this way we get the elements which are common in both the arrays.

#without using additional space
# Time complexity - o(mlogm)+o(nlogn)+o(m)+o(n)
# space complexity - o(1)
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        out=[]
        nums1.sort()
        nums2.sort()
        i=len(nums1)-1
        j=len(nums2)-1
        while i>=0 and j>=0:
            if nums1[i]==nums2[j]:
                out.append(nums1[i])
                i=i-1
                j=j-1
            elif nums2[j]>nums1[i]:
                j=j-1
            else:
                i=i-1
        return out
                
                
        