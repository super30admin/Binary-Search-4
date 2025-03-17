#time: O(m(log(m)))
#space:O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #sorting the two arrays
        nums1= sorted(nums1)
        nums2=sorted(nums2)
        final=[]
        index=0
        #iterate the first array and find the first occurence of the element in the second array via binary search
        for i in range(len(nums1)):
            loc= self.binarysearch(index, nums2,nums1[i])
            if loc < len(nums2) and (nums1[i] == nums2[loc]):
                final.append(nums1[i])
                index=loc+1
        return final

    def binarysearch(self,low,arr,target):
        high= len(arr)-1
        while low <= high:
            mid = low + int((high-low)/2)
            #if target is bigger then use right subarray
            if arr[mid] < target:
                low=mid +1
            #else always got to the left one in order to find the first occurence
            else:
                high= mid-1
        return low
