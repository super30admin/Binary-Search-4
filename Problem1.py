#Time complexity: O(nlogn) + O(mlogm) (for sorting) +  O(nlogm) for searching
#Space complexity: O(1)

#Accepted on Leetcode

#Approach
#Sort both arrays -> now iterate through the smaller one -> for each elem execute binary search on larger one
#Find leftmost occurrence of element in larger array, then move the index of search to 'foundIndex' + 1 (to prevent duplicates) -> End when either of the arrays exhausted
#If a given element does not occur in larger array -> compare whether it is smaller/greater than current element and move accordingly


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        #result arr
        result = []
        #Sort both arrays
        nums1.sort()
        nums2.sort()
        n = len(nums1)
        m = len(nums2)

        if n > m:
            #nums 1 considered smaller always
            return self.intersect(nums2,nums1)
        
        #Iterate over nums1 - smaller list
        p = 0
        for x in nums1:
            findIndex = bisect_left(nums2,x,p,len(nums2))
            if findIndex == len(nums2):
                break
            elif nums2[findIndex] == x:
                result.append(x)
                p = findIndex + 1
            else:
                if nums2[findIndex] < x:
                    p = findIndex + 1
                else:
                    p = findIndex


        return result


