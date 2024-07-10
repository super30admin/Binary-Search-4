# Time Complexity :
# O(m+n) , Using Hash-Map


# Space Complexity :  
# O(m+n), Since you are creating "result" array that stores all elemts in worst case



class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if not nums1 and not nums2 :
            return []

        m = len(nums1)
        n = len(nums2)

        if(m<n):   # make HashMap(key: numn, value: freq) for smaller array
            self.intersect(nums2, nums1)

        hashMap = {}
        for i in range(0, n):
            if nums2[i] in hashMap.keys():
                hashMap[nums2[i]] += 1
            else:
                hashMap[nums2[i]] = 1

        result= []
        for i in range(0,m):
            if nums1[i] in hashMap.keys():
                result.append(nums1[i])
                hashMap[nums1[i]] -= 1
                if hashMap[nums1[i]] == 0:
                   del hashMap[nums1[i]]

        return result