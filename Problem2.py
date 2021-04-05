  # Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    # 1) Follow up question 1: What if the given array is already sorted? How would you optimize your algorithm?
    # Time = O(m + n) | space = O(n) where n is the nums array with greater length.
    def intersect(self, nums1, nums2):
        result = []
        if len(nums1) == 0 or len(nums2) == 0 or nums1 == None or nums2 == None:
            return result 
        
        if len(nums1) > len(nums2):
            self.intersect(nums2, nums1) 
        
        result = []
        map = {}
        for indx in range(len(nums2)):
            if nums2[indx] not in map:
                map[nums2[indx]] = 1 
            else:
                map[nums2[indx]] += 1 
        
        for indx in range(len(nums1)):
            if nums1[indx] in map:
                map[nums1[indx]] -= 1 
                result.append(nums1[indx])
                if map[nums1[indx]] == 0 :
                    map.pop(nums1[indx])
        
        return result

    # Follow-up question 2: what is the arrays are sorted? (I sorted them manually and will not count its tc)
    # Time = O(max(m,n)) | space = O(1) 
    def intersect(self, nums1, nums2):
        result = []
        if len(nums1) == 0 or len(nums2) == 0 or nums1 == None or nums2 == None:
            return result 
        # Follow-up question 2, what if the arrays are sorted. 
        nums1.sort()
        nums2.sort()
        
        # Two pointer approach.
        result = []
        indx1 = 0 
        indx2 = 0 
        while indx1 < len(nums1) and indx2 < len(nums2):
            if nums1[indx1] == nums2[indx2]:
                result.append(nums1[indx1])
                indx1 += 1 
                indx2 += 1 
            elif nums1[indx1] < nums2[indx2]:
                indx1 += 1 
            else:
                indx2 += 1 
        return result 
    
    # Follow up question 3:  What if nums1's size is small compared to nums2's size? Which algorithm is better?
    # we can do binary search for each element in nums1(with size k) in nums2. So tc will be 
    # O(klogn) < O(max(m, n)) . 
    # Time = O(klogn) | Space = O(1)
    def intersect(self, nums1, nums2):
        result = []
        if len(nums1) == 0 or len(nums2) == 0 or nums1 == None or nums2 == None:
            return result 
        # Follow-up question 3, what if the arrays are sorted and nums1 is smaller. 
        nums1.sort()
        nums2.sort()
        
        if len(nums2) < len(nums1):
            return self.intersect(nums2, nums1)
                        
        result = []
        low = 0
        # we will do binary search for all the elements from the smaller nums1 array.
        for indx in range(len(nums1)):
            resIndx = self.__binarySearch(nums2, nums1[indx],low, len(nums2)-1)
            if resIndx != -1:
                result.append(nums1[indx])
                low = resIndx + 1 
        return result 
    
    def __binarySearch(self, arr, target, low ,high):
        while low <= high:
            mid = (low + high) // 2 
            
            if arr[mid] == target :
                if mid == low or arr[mid] > arr[mid -1]:
                    return mid
                else:
                    high = mid - 1 
                    
            elif arr[mid] < target:
                low = mid + 1 
            else:
                high = mid - 1 
        return -1 
    
    # Follow-up question 4 : What if elements of nums2 are stored on disk, 
    # and the memory is limited such that you cannot load all elements into the memory at once?
    # Ans : may be use Map Reduce.
    


if __name__ == "__main__":
    s = Solution()
    # Test Case 1
    nums1 = [1,2,2,1]
    nums2 = [2,2]
    res = s.intersect(num1, num2)
    print(res)
        