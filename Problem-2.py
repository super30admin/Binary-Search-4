# Time Complexity :average O(n*m)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        #create result array
        result = []
        #iterate over all numes 1
        for i in range(len(nums1)):
            # iterate over all nums two
            for j in range(len(nums2)):
                #if yoy find it mark it as used and break, append it to result
                if nums1[i] == nums2[j]:
                    result.append(nums1[i])
                    nums2[j] = nums2[j] * -1
                    break
        #return result       
        return result




# Time Complexity :average O(max(n,m))
# Space Complexity :O(len(nums1)) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
from collections import Counter
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        #get count of all numbers in nums1
        count = Counter(nums1)
        # create result array
        result = []
        #iterate over nums two
        for i in nums2:
            #if i is in nums one too
            if i in count:
                # add it to result
                result.append(i)
                # reduce its count and if reach zero remove it from the map
                count[i] -=1
                if count[i] == 0:
                    del count[i]
        #return result
        return result




# Time Complexity :if two arrays sorted average O(mlogn)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def binsearch(self,low,high,nums1,i):
        #normal binary search
        while low <= high:
            mid = low + (high - low)/2
            #make sure that you are not before the low pointer and that this is the first occurance of i
            if (nums1[mid] == i) and (mid == low  or nums1[mid] > nums1[mid-1] ):
                return mid
            elif nums1[mid] < i:
                low = mid+1
            else:
                high = mid-1
        return -1
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # make sure the biggest one is the one you will do binary search on to reduce complexity
        if len(nums2) > len(nums1):
            return self.intersect(nums2,nums1)
        result = []
        #sort them if not sorted
        nums1.sort()
        nums2.sort()
        low = 0
        #iterate over nums2
        for i in nums2:
            #search for i
            index = self.binsearch(low,len(nums1)-1,nums1,i)
            # if there
            if index != -1:
                #change low index
                low = index +1
                #append i to result
                result.append(i)
        #return result
        return result