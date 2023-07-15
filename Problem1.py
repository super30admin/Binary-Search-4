#Time complexity is:O(mlogn)
#Space complexity is:O(1)
#Code ran successfully on leet code
#No issues faced while coding
class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        #Taking the length of both the arrays
        m=len(nums1)
        n=len(nums2)
        #Making sure that first array is small than second one
        if(m>n):
            self.intersect(nums2,nums1)
        li=[]
        #Sorting both the arrays
        nums1.sort()
        nums2.sort()
        low=0
        high=n-1
        #Performing the bonary search to find the inde of the target value
        for i in range(0,m):
            target=nums1[i]
            bsIdx=self.binarySearch(nums2,low,high,target)
            #If the target value is found, we will move the low to bsIdx+1 
            #to reduce the size of the array to be considered
            if(bsIdx!=-1):
                li.append(target)
                low=bsIdx+1
        #returning the final list
        return li

    #Performing the binary search on the array
    def binarySearch(self,nums2,low,high,target):
        while(low<=high):
            mid=low+(high-low)/2
            #We will fing the mid and we will compare with the target value
            if(nums2[mid]==target):
                if(mid==low or nums2[mid]!=nums2[mid-1]):
                    return mid
                else:
                    high=mid-1
            #Based on the condtions in the if statement, the flow will continue
            elif(nums2[mid]>target):
                high=mid-1
            else:
                low=mid+1
        #If the value is not foun, we will return -1
        return -1
