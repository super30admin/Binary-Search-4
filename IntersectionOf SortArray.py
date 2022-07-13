#350. Intersection of Two Arrays II
"""
Time Complexity : O(m log n)
Space Complexity : O(1)
"""
class Solution:
    def binarySearch(self,nums,low,high,target):
            while(low <= high):
                mid = int(low+ ((high-low)/2))
                if nums[mid] == target:
                    if mid == low or nums[mid] != nums[mid-1]:

                        return mid
                    else:
                        high = mid -1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

            return -1 
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        """
        d = dict()
        for i in nums1:
            if i not in d:
                d.update({i : 1})
            else:
                d.update({i : d.get(i) + 1})
                
        li = []
        for i in nums2:
            if i in d:
                li.append(i)
                d.update({i : d.get(i) - 1})
                
                if d.get(i) == 0:
                    del d[i]
        return li
        """
        
        """
        #two pointers
        nums1.sort()
        nums2.sort()
        
        p1 = 0
        p2 = 0
        li = []
        while ( p1 < len(nums1) and p2 < len(nums2) ):
            if nums1[p1] == nums2[p2]:
                li.append(nums1[p1])
                p1+=1
                p2+=1
            elif nums1[p1] < nums2[p2]:
                p1+=1
            else:
                p2+=1
        
        return li
        """
        #binary search
        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        high = len(nums2) - 1
        for i in range(len(nums1)):
            bsIndex = self.binarySearch(nums2,low,high,nums1[i])
            if bsIndex != -1:
                result.append(nums1[i])
                low = bsIndex+1

        return result


        
