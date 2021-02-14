# Time Complexity: O(mlogn)
Space: O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        def binarySearch(nums2, target,index):
            beg = index
            end = len(nums2)-1
            res = -1
            while(beg<=end):
                mid = (beg+end)//2
                if(nums2[mid]==target):
                    res = mid
                    end = mid - 1
                elif(nums2[mid]>target):
                    end = mid - 1
                else:
                    beg = mid + 1
            
            return res
        
        
        
        if(len(nums2)<len(nums1)):
            return self.intersect(nums2,nums1)
        
        # apply binary search on nums2 to find nums1 array
        nums1.sort()
        nums2.sort()
        o = []
        x=0
        found=True
        for i in nums1:
            y = binarySearch(nums2,i,x)
            if(y!=-1):
                o.append(i)
                x = y+1
        return o
