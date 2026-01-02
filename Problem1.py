## Problem1 
# Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

# Method-1: Using frequency map to store key and frequency of smaller length array, then iterating the larger length array to find
# intersection elements
# nums1.length == m
# nums2.length == n
# Time Complexity : O(m + n)
# Space Complexity : O(min(m,n))
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Put the smaller array in the hash map. Then go over the larger array and find out the intersection elements with the hash map. 
# The ones we find common we can keep appending to the result and also reducing the count from the frequency map. If the count 
# in the frequency map becomes 0 -- remove from the map -- as we need only the elements that are common

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # make key:frequency map of the smaller length array
        if(len(nums2) < len(nums1)):
            # 
            return self.intersect(nums2, nums1)

        freqMap = {}
        for i in range(len(nums1)):
            if(nums1[i] not in freqMap):
                freqMap[nums1[i]] = 0

            freqMap[nums1[i]] += 1
        
        res = []
        # now check for intersection in the second array
        for i in range(len(nums2)):
            if(nums2[i] in freqMap):
                res.append(nums2[i])
                freqMap[nums2[i]] -= 1
                if(freqMap[nums2[i]] == 0):
                    del freqMap[nums2[i]]

        return res

sol = Solution()
print("Method-1: Using frequency map to store key and frequency of smaller length array, then iterating the larger length array to find")
print(sol.intersect([1,2,2,1], [2,2]))
print(sol.intersect([4,9,5], [9,4,9,8,4]))

# Follow - up: what if the arrays are sorted?


# Method-2: Sorting, and then using two pointers
# intersection elements
# nums1.length == m
# nums2.length == n
# Time Complexity : O((m * log m) + (n * log n)) + O(m + n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This is a really good approach when arrays are sorted. We use two pointers to note the equal elements. When they are not equal
# then we move the pointer with the smaller value.


class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        # using two pointers on sorted arrays
        nums1.sort()
        nums2.sort()
        i = 0 # pointer on nums1
        j = 0 # pointer on nums2
        res = []
        while((i < len(nums1)) and (j < len(nums2))):
            if(nums1[i] == nums2[j]):
                res.append(nums1[i])
                i += 1
                j += 1
            elif(nums1[i] > nums2[j]):
                j += 1
            else:
                # nums1[i] < nums2[j]
                i += 1

        return res
    
sol = Solution()
print("Method-2: Sorting, and then using two pointers")
print(sol.intersect([1,2,2,1], [2,2]))
print(sol.intersect([4,9,5], [9,4,9,8,4]))


# Method-3: Sorting, and then using modified binary search
# intersection elements
# nums1.length == m(smaller length array)
# nums2.length == n(larger length array)
# Time Complexity : O((m * log m) + (n * log n)) + O(m * log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# This is good approach when arrays are sorted. We iterate over each element of the smaller length array, and we try to search
# the first occurence(index) of the element in the larger length array using binary search in the range. If we found the element in 
# the larger length array, we update our low to index + 1, so that we do not count the duplicates again

class Solution(object):
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        def binarySearch(target, low, high, arr):
            while(low <= high):
                mid = low + ((high - low) // 2)
                if(arr[mid] == target):
                    # check if it is the first occurence of the target in the range
                    if(low == mid or (arr[mid - 1] != target)):
                        # if it is the first element of the range or the previous element is 
                        # different
                        return mid
                    else:
                        # there are duplicates at earlier indices
                        high = mid - 1

                elif(target > arr[mid]):
                    low = mid + 1
                else:
                    # target < arr[mid]
                    high = mid - 1

            return -1

        # using modified binary search on sorted arrays
        if(len(nums1) > len(nums2)):
            return self.intersect(nums2, nums1)

        # do binary search on the larger array
        # for each element in the smaller array(nums1), find the first occurence of that value in 
        # larger array(nums2)
        nums1.sort()
        nums2.sort()
        res = []
        low = 0
        for i in range(len(nums1)):
            idx = binarySearch(nums1[i], low, len(nums2) - 1, nums2)
            # since the elements are sorted, for a value of nums1 if we find the index of first
            # occurence in nums2, it means the remaining elements of nums1 would be greater than
            # that element. So previous elements of nums2 could be ignored and our new binary 
            # search range would be start from idx + 1
            # In case of duplicates it would work fine as we find the first occurence of the
            # value in nums2 and our range starts from idx + 1
            if(idx != -1):
                res.append(nums1[i])
                low = idx + 1

            
            if(low >= len(nums2)):
                break
        

        return res


sol = Solution()
print("Method-3: Sorting, and then using modified binary search")
print(sol.intersect([1,2,2,1], [2,2]))
print(sol.intersect([4,9,5], [9,4,9,8,4]))