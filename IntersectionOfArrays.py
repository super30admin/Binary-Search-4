#All TC on leetcode passed

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        #Binary search approach, here B.S. is performed on array with bigger size. Every element in array of smaller size is searched in array of bigger size.
        #Time complexity - O(nlog) + O(mlogm) + O(mlogn) where m and n are lengths of 2 arrays and the log factor is due to sorting. m - array with smaller size, n-array with bigger size
        #Sapce complexity - O(1)
        

        res = []

        if len(nums1)<len(nums2):
            nums1, nums2 = nums2, nums1

        nums1.sort()
        nums2.sort()
        
        l = 0
        h = len(nums1)-1

        for n in nums2:
            idx = self.searchNum(l, h, n, nums1)
            if idx!=-1:
                res.append(n)
                l = idx+1
        return res

    def searchNum(self, l, h, target, nums):
        while l<=h:
            mid = (l+h)//2

            if nums[mid]==target:
                if mid==l or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    h = mid-1

            elif nums[mid]<target:
                l = mid+1
            else:
                h = mid-1
        
        return -1

        
            
        

#-----------------------------------------------OR----------------------------------------------

        

        #Two pointer approach
        #Time complexity - O(nlog) + O(mlogm) + O(m+n) where m and n are lengths of 2 arrays and the log factor is due to sorting. 
        #Sapce complexity - O(1)
        res = []

        nums1.sort()
        nums2.sort()

        i=0
        j=0
        while i<len(nums1) and j<len(nums2):
            if nums1[i]==nums2[j]:
                res.append(nums1[i])
                i+=1
                j+=1
            elif nums1[i]<nums2[j]:
                i+=1
            else:
                j+=1

        return res


#-----------------------------------------------OR----------------------------------------------


        #Using hashmap approach to store elements of shorter array in map.
         #Time complexity - O(m+n) where m and n are lengths of 2 arrays and the log factor is due to sorting. 
        #Sapce complexity - O(n) length of shorter array stored in dict
        dict = collections.defaultdict(int)
        res = []

        if len(nums1)>len(nums2):
            nums1, nums2 = nums2, nums1

        for n in nums1:
            dict[n]+=1

        for n in nums2:
            if n in dict:
                res.append(n)
                dict[n]-=1
                if dict[n]==0:
                    dict.pop(n)
        
        return res





