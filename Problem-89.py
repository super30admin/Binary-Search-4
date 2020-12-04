# Leet code- Intersection of two arrays -2 -  https://leetcode.com/problems/intersection-of-two-arrays-ii/


# Brute force solution -  time complexity - O(M*N)
# Hash map solution - time complexity - O(M+N) - space complexity - O(M+N)



# Time complexity - O(Nlogn)
# space Complexity - O(1)
# Approach - Two pointers approach

class Solution(object):
    def intersect(self, nums1, nums2):
        nums1.sort()
        nums2.sort()
        res=[]
        i,j=0,0
        while i<len(nums1) and j<len(nums2):
            if nums1[i]>nums2[j]:
                j=j+1
            elif nums1[i]<nums2[j]:
                i=i+1
            else:
                res.append(nums1[i])
                i=i+1
                j=j+1
        return res
        
