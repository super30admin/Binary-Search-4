class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #Method 1: Hashmap - TC O(m+n)
        # if len(nums1)<len(nums2):
        #     nums1,nums2=nums2,nums1
        # res=[]
        # hashmap={}
        # for n in nums2:
        #     if n in hashmap:
        #         hashmap[n]+=1
        #     else:
        #         hashmap[n]=1
        
        # for n in nums1:
        #     if n in hashmap and hashmap[n]>0:
        #         hashmap[n]-=1
        #         res.append(n)
        # return res

        #If arrays are sorted
        #Method 1 - 2 pointers -> O(m+n)
        # if len(nums1)>len(nums2):
        #     nums1,nums2=nums2,nums1
        # nums1=sorted(nums1)
        # nums2=sorted(nums2)

        # n1=0
        # n2=0
        # res=[]
        # while n1<len(nums1) and n2<len(nums2):
        #     if nums1[n1]==nums2[n2]:
        #         res.append(nums1[n1])
        #         n1+=1
        #         n2+=1
        #     elif nums1[n1]<nums2[n2]:
        #         n1+=1
        #     else:
        #         n2+=1
        # return res

        #Method 2 - Modified Binary Search  -> O(mlogn)
        l1 = len(nums1)
        l2 = len(nums2)
        nums1.sort()
        nums2.sort()
        res = []
        if l2 < l1 : 
            self.intersect(nums2,nums1)

        left = 0 
        right = l2-1 

        for each in nums1 : 
          idx =  self.binarySearch(left,right,each,nums2)
          if idx != -1:
              res.append(each)
              left = idx + 1 #everytime you find an element, increase left pointer to idx+1 to avoid going over same element in nums2.

        return res

    def binarySearch(self,left,right,target,nums2): 

        while left <= right: 
            mid = left + (right-left)//2 
            if nums2[mid] == target : 
                if left == mid or nums2[mid] != nums2[mid-1]:  #1st if -> mid== left(current range's left most part) or 2nd if -> go left till mid-1 isn't equal to mid
                    return mid
                else: #if it is, move left in your binary search
                    right = mid -1 
            elif nums2[mid] < target: 
                left = mid + 1 
            else :
                right = mid -1 
        return -1 

        

        







