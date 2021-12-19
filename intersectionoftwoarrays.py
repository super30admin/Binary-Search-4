class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """intersection here means min occurence of each common element"""
        """Solution 2: Two pointers and sorting"""
        """
        Time Complexity: 

O(nlogn+mlogm), where n and m are the lengths of the arrays. We sort two arrays independently, and then do a linear scan.

Space Complexity: from 

O(logn+logm) to 
O(n+m), depending on the implementation of the sorting algorithm. For the complexity analysis purposes, we ignore the memory required by inputs and outputs.
        """

        ######
        result=[]
        if nums1 is None or nums2 is None:
            return result
        if len(nums1)<len(nums2):
            return self.intersect(nums2, nums1)
        nums1.sort()
        nums2.sort()
        p1=0
        p2=0
        while p1 < len(nums1) and p2<len(nums2):
            if nums1[p1]==nums2[p2]:
                result.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1]> nums2[p2]:
                ###move smaller
                p2+=1
            else:
                p1+=1

        return result



#         # TC: O(n+m)
#         # SC: min(n,m)
#         result=[]
#         if nums1 is None or nums2 is None:
#             return result
#         ###assuming the first array to be smaller one and the second to be bigger
#         ###if happens in opposite way thenm
#         if len(nums1)<len(nums2):
#             return self.intersect(nums2, nums1)
#         hashmap={}
#         for num in nums1:
#             if num in hashmap:
#                 hashmap[num]+=1
#             else:
#                 hashmap[num]=1
#         for num in nums2:
#             if num in hashmap:
#                 result.append(num)
#                 hashmap[num]-=1
#                 if hashmap[num]==0:
#                     hashmap.pop(num)
#         return result




