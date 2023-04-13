class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # # hashmap solution
        # #TC - O(m+n)
        # #SC - O(min(m,n))
        # # make sure that first array is of smaller length
        # if len(nums2)< len(nums1):
        #     return self.intersect(nums2,nums1)
        # # hashmap of counts of smaller array
        # d = {}
        # res=[]
        # for i in nums2: #O(m)
        #     if i in d:
        #         d[i]+=1
        #     else:
        #         d[i]=1
        # # loo through the second array, and check them in hashmap, reduce the count of hashmap
        # for k in nums1:  #O(n)
        #     if k in d and d[k]>0:
        #         res.append(k)
        #         d[k]-=1
        # return res

        # two pointers if arrays are already sorted
        # TC-O(m+n) considering sorted arrays
        # SC-O(1)
        # nums1.sort()
        # nums2.sort()
        # p1 = 0 
        # p2 = 0
        # res=[]
        # # if numbers at both pointers are same, add to result, move the pointer with least element forward by one
        # while p1<len(nums1) and p2<len(nums2):
        #     if nums1[p1]==nums2[p2]:
        #         res.append(nums1[p1])
        #         p1+=1
        #         p2+=1
        #     elif nums1[p1]<nums2[p2]:
        #         p1+=1
        #     else:
        #         p2+=1
        # return res

        # binary search 
        # arrays should be sorted
        def binarysearch(nums2,low,high,target):
            print(low,high)
            while low<=high:
                mid = low+(high-low)//2
                print(nums2[mid],target)
                if nums2[mid]==target:
                    # to get the first occurence of an element, if mid == mid-1, move high to mid-1 
                    if mid>low and  nums2[mid]==nums2[mid-1]:
                        high = mid-1
                    else:
                        return mid
                elif nums2[mid]>target:
                    high = mid-1
                else:
                    low=mid+1
            return -1

        if len(nums2)< len(nums1):
            return self.intersect(nums2,nums1)
        nums1.sort()
        nums2.sort()
        p1=0
        p2=0
        low=0
        res=[]
        high=len(nums2)-1
        for i in range(len(nums1)):
            # binary search that element, get its index
            print(nums2,low)
            ind = binarysearch(nums2,low,high,nums1[i])
            if ind != -1:
                # move low to ind+1 to avoid getting the same element and append to res
                low = ind + 1
                res.append(nums1[i])
        return res
            
        
