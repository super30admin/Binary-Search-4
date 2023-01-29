# TC: O(logm) # where m is the smaller List
# SC: O(1)

# The idea is to create a parition in both arrays such that
# total elements on right and left are equal
# if total elements are 10
# then 5 elements should be on each side
# so if there are 2 elements in array1 on right then in array2 3 elements will be there
# we perform binary search on the smaller array


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:

        if(((nums1 is None) and (nums2 is None)) or ((len(nums1)==0) and (len(nums2)==0))):
            return float(0)

        m = len(nums1)
        n = len(nums2)
        if m>n:
            #keeping the smaller one as the first
            return self.findMedianSortedArrays(nums2,nums1)

        low = 0
        high = m #since we will be using prev value to high

        while low<=high:
            partX = low + ((high-low)//2)
            partY = (m+n)//2 - partX

            leftX = -sys.maxsize if partX==0 else nums1[partX-1]
            leftY = -sys.maxsize if partY==0 else nums2[partY-1]

            rightX = sys.maxsize if partX==m else nums1[partX]
            rightY = sys.maxsize if partY==n else nums2[partY]

            if leftX<=rightY and leftY<=rightX:
                if (m+n)%2==0:
                    return float((max(leftX,leftY)+(min(rightX,rightY)))/2)
                else:
                    return float(min(rightX,rightY))
            elif leftX>rightY:
                high = partX-1
            else:
                low = partX+1

        return 0.0
