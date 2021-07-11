class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        TC : O(nlogn) + O(nlogn) + O(max(len(nums1), len(nums2)))
        SC: O(min(len(nums1), len(nums2)))
        """
        nums1.sort()
        nums2.sort()
        p1=0
        p2=0
        res=[]
        while p1 < len(nums1) and p2 < len(nums2):
            if nums1[p1]<nums2[p2]:
                p1+=1
            elif nums2[p2]<nums1[p1]:
                p2+=1
            elif nums1[p1]==nums2[p2]:
                res.append(nums1[p1])
                p1+=1
                p2+=1
        return res

        # other bruteforce 
        # TC: O(n1*n2), SC: O(min(n1,n2))

         res=[]
        for i in range(len(nums1)):
            for j in range(len(nums2)):
                if nums1[i]==nums2[j]:
                    res.append(nums1[i])
        return set(res)