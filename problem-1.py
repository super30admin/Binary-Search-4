# Leetcode excution: YES
# time complexity: O(len(nums2)) or O(n)
# space complexity: O(1)
class Solution:
    def intersect(self, nums1: list, nums2: list) -> list:
        # we will be using two pointer appriach since the arrays are not sorted 
        # making sure that nums1 have less size 
        if len(nums2)<len(nums1):
            return self.intersect (nums2,nums1)
        
        mapp={}
        result=[]
        # copy the count of each element in nums1 to hash map
        for x in nums1:
            if x in mapp:
                mapp[x]+=1
            else:
                mapp[x]=1
        # loop through the nums2 and chcek if it is in hash map if yes, then add that in result array and decrese its count in map
        # if couunt becomes 0 we remove the element from the map
        # finally we return result array 
        for x in nums2:
            if x in mapp:
                result.append(x)
                mapp[x]-=1
                if mapp[x]==0:
                    mapp.pop(x)
        return result
                
        