"""
The approach here is to store the count of all the numbers in a dict and then sort the 2nd array, now
iterate through the array, and if the element is found in the dict, then we decrease count by 1 and append
the element to the result array.
Leetcode - Running
Time complexity - O(N^2)
Space complexity - O(N)
"""
def intersect(self, nums1, nums2):
        dict1 = {}
        for num in nums1:
            if num in dict1:
                dict1[num] += 1
            else:
                dict1[num] = 1
                
        result = []
        nums2.sort()
        for num in nums2:
            if num in dict1 and dict1[num] > 0:
                dict1[num] -= 1
                result.append(num)
        return result