class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        n1 = len(nums1)
        n2 = len(nums2)

        nums1.sort()
        nums2.sort()

        if(n1>n2):
            return self.intersect(nums2,nums1)

        result = []

        low = 0
        high = n2-1

        for num in nums1:
            bsIndex = self.binarySearch(nums2,low,high,num)
            if(bsIndex != -1):
                result.append(num)
                low = bsIndex + 1
        
        return result

    def binarySearch(self,arr,low,high,target):
        while(low<=high):
            mid = low + (high - low)//2
            if(arr[mid] == target):
                if(mid == low or arr[mid] != arr[mid - 1]):
                    return mid
                else:
                    high = mid - 1
            elif(arr[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        
        return -1

        