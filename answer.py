1.Intersection of Two Arrays II

Time Complexity: O(m+n)
Space Complexity: O(m) or O(n) whichever is min
Leetcode: YES


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)
        dict = {}
        result = []
        if(m > n): return self.intersect(nums2, nums1)
        for i in range(m):
            if nums1[i] in dict:
                dict[nums1[i]] += 1
            else:
                dict[nums1[i]] = 1
        for i in range(n):
            if nums2[i] in dict:
                result.append(nums2[i])
                dict[nums2[i]]-=1
                if dict[nums2[i]] == 0: dict.pop(nums2[i])

        return result


2.Median of Two Sorted Arrays

Time Complexity: O(log(min(n1,n2))
Space Complexity: O(1)
Leetcode: YES

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1 = len(nums1)
        n2 = len(nums2)
        if(n1==0 and n2==0): return 0.0
        if(n1>n2): 
            return self.findMedianSortedArrays(nums2,nums1)
        low = 0
        high = n1
        while(low<=high):
            partX = low + (high - low)//2
            partY = (n1+n2)//2 - partX
            L1 = float(-inf) if partX == 0 else nums1[partX-1]
            R1 = float(inf) if partX == n1 else nums1[partX]
            L2 = float(-inf) if partY == 0 else nums2[partY-1]
            R2 = float(inf) if partY == n2 else nums2[partY]
            if(L1<=R2 and L2<=R1):
                #get the median
                if((n1+n2)%2!=0):
                    return min(R1,R2)
                else:
                    return (min(R1,R2)+max(L1,L2))/2
            elif(L2>R1):
                low = partX + 1
            else:
                high = partX - 1
        return 123456.7890

