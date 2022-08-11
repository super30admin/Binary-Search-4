from pip import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        combined = []
        i = 0
        j = 0
        while(i<len(nums1) and j<len(nums2)):
            if(nums1[i] < nums2[j]):
                combined.append(nums1[i])
                i+=1
            else:
                combined.append(nums2[j])
                j+=1
        while(i<len(nums1)):
            combined.append(nums1[i])
            i+=1
        while(j<len(nums2)):
            combined.append(nums2[j])
            j+=1
        n = len(combined)
        if(n%2==0):
            b = int(n/2)
            return (combined[b]+combined[b-1])/2
        else:
            b = int(n/2)
            return combined[b]
        