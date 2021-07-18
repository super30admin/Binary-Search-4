import collections
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        if len(nums1)>len(nums2):
            return self.intersect(nums2,nums1)
        res = []
         #binary search: if sorted, time is O(mlogn), space is O(1)
        p1,p2 =0,0
        nums1.sort()
        nums2.sort()
        def binarysearch(target,nums,low,high):
            while low<=high:
                mid = low + (high-low)/2
                if nums[mid] == target:
                    if low == mid or nums[mid]>nums[mid-1]:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid +1
            return -1
        low,high = 0,len(nums2)-1            
        for el in nums1:
            binIdx = binarysearch(el,nums2,low,high)
            if binIdx != -1:
                low = binIdx + 1
                res.append(el)
        return res
        
        # #two pointer: if sorted, time is O(m+n), space is O(1)
        # p1,p2 =0,0
        # nums1.sort()
        # nums2.sort()
        # while p1<len(nums1) and p2<len(nums2):
        #     if nums1[p1] == nums2[p2]:
        #         res.append(nums1[p1])
        #         p1+=1
        #         p2+=1
        #     elif nums1[p1] < nums2[p2]:
        #         p1+=1
        #     else:
        #         p2+=1
        # return res
                
        #hashmap: O(m+n) time, O(n) space
        # mp = dict(collections.Counter(nums1))
        # for i in xrange(len(nums2)):
        #     if nums2[i] in mp:
        #         res.append(nums2[i])
        #         mp[nums2[i]] = mp[nums2[i]] - 1
        #         if mp[nums2[i]] == 0:
        #             del mp[nums2[i]]         
        # return res
        
        
