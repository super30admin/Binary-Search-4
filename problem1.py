#time complexity: O(mlog(n))
#space complexity: O(1)
#ran on leetcode: Yes
#Sort the array. For each element in the first array, check whether it is in the second array using binary search. If it is present, get the index and for the next element search from this index+1. Similarly a element occrs more than once, return the leftmost index.
class Solution:
    def binary_search(self,nums,target,index):
        low=index
        high=len(nums)-1
        mid=-1
        found=False
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                found=True
                break
            elif(nums[mid]>target):
                high=mid-1    
            else:
                low=mid+1
        
        if(not found):
            return -1
        else:
            #curr=nums[mid]
            k=mid
            while(k>=index and nums[k]==target):
                k-=1
            return k+1    

    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #nums1 should always be lesser
        print("OUTSIDE")
        nums1.sort()
        nums2.sort()
        res=[]
        index=0
        #ans=self.binary_search(nums2,nums1[0],index)
        print("OUTSIDE")
        for i in range(len(nums1)):
            #print(i)
            ans=self.binary_search(nums2,nums1[i],index)
            if(ans!=-1):
                res.append(nums1[i])
                #print(ans)
                index=ans+1
        
        #print(nums1)
        #print(nums2)
        return res

        



