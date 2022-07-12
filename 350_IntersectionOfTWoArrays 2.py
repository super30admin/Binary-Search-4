class Solution:

    # brute Force using HashMap
    # Time Complexity: O(m+n)
    # Space Complexity: O(m)
    # Take hashmap for smaller array
    # in hashmap count the number of integers in smaller array
    # after making hashmap, take each elemnt of second array and decease the count by 1 if it is in hashmap 
    # append that integer in result
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        result = []
        hashMapDict = {}
        for i in nums1:
            if i not in hashMapDict:
                hashMapDict[i] = 1
            else:
                hashMapDict[i] +=1
                
        for i in nums2:
            if i in hashMapDict:
                hashMapDict[i] -= 1
                if hashMapDict[i] == 0:
                    del hashMapDict[i]
                result.append(i)

                
        return result


    # using two pointers in both arrays 
    # Time Complexity: O(m+n)
    # if there is given that, arrays are sorted than this one will work.
    # take one pointer in first array and second pointer on second array
    # if both integers are equal than, add to result and move pointers in both arrays
    # if not, move only that pointer which consist the smaller integer, because it is sorted arrays.
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        nums1.sort()
        nums2.sort()
        result = []
        p1 = 0
        p2 = 0
        while p1< len(nums1) and p2<len(nums2):
            if (nums1[p1] == nums2[p2]):
                result.append(nums1[p1])
                p1 +=1
                p2 +=1
            elif nums1[p1] < nums2[p2]:
                p1 +=1
            else:
                p2 +=1
        return result
    


    # Binary serach on one array
    # Time Complexity: O(m*log(n))
    # take integer from smaller array and do binary search on larger array.
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        nums1.sort()
        nums2.sort()
        result = []
        low = 0
        high = len(nums2) - 1
        for i in range(len(nums1)):
            bsIndex = self.binarySearch(nums2,low,high,nums1[i])
            if bsIndex != -1:
                result.append(nums1[i])
                low = bsIndex+1
        
        return result
        
    
    def binarySearch(self,nums,low,high,target):
        while(low <= high):
            mid = int(low+ ((high-low)/2))
            if nums[mid] == target:
                if mid == low or nums[mid] != nums[mid-1]:
                    
                    return mid
                else:
                    high = mid -1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return -1