# Solution

# // Time Complexity : Dictionary Approach: O(m+n), m-length of nums1,n-length of nums2
#                      Sort and Two pointer approach: O(max(m,n)) if we ignore the sorting time[Because follow up question for
#                      this question was, how do you solve it if it was already sorted]
#                      Sort and Binary search: O(mlogm) where m is larger between m and n. if we ignore the sorting time[Because follow up question for
#                      this question was, how do you solve it if it was already sorted]
# // Space Complexity : Dictionary Approach: O(m) where m is smaller between m and n
#                       Sort and Two pointer approach: O(1)
#                       Sort and Binary search: O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Dictionary Approach: Add all elements of array with smaller length into a dictionary and keep incrementing the count if number
#                      repeats. Now run a loop on second array and check, if number exists then add that to result and decrease
#                      count in dictionary. Remove from dicitonary if count becomes 0
# Two Pointer Approach: Just sort the two arrays and then use two pointer approach to check if elements exists in both arrays.
#                       Always move the pointer of smaller value element when value is not equal, and move both pointers when
#                       value is equal
# Binary Search Approach: Sort the two arrays. Now perform binary search on longer array for elements in smaller array. Remember
#                         to perform binary search till you find the leftmost element of the array

def binarySearch(nums,low,high,target):
    while low<=high:
        mid = low+((high-low)//2)

        if nums[mid] == target:
            if mid == low or nums[mid] != nums[mid-1]:
                return mid
            else:
                high = mid-1

        elif nums[mid] < target:
            low = mid+1
        else:
            high = mid-1
    
    return -1

def intersect(nums1,nums2):

    # Binary Search Approach
    n1 = len(nums1)
    n2 = len(nums2)

    if n2<n1:
        return intersect(nums2,nums1)
    
    nums1.sort()
    nums2.sort()

    low = 0
    high = n2-1
    result = []
    for num in nums1:

        idx = binarySearch(nums2,low,high,num)

        if idx != -1:
            result.append(num)
            low = idx+1

    return result

    # Two Pointer Approach
    # nums1.sort()
    # nums2.sort()
    # n1 = len(nums1)
    # n2 = len(nums2)

    # pointer1 = 0
    # pointer2 = 0
    # result = []

    # while pointer1<n1 and pointer2<n2:
    #     if nums1[pointer1] == nums2[pointer2]:
    #         result.append(nums1[pointer1])
    #         pointer1 += 1
    #         pointer2 += 1
    #     elif nums1[pointer1] < nums2[pointer2]:
    #         pointer1 += 1
    #     else:
    #         pointer2 += 1
    
    # return result

    # Dictionary Approach
    # minDict = {}

    # n1 = len(nums1)
    # n2 = len(nums2)
    # result = []

    # if n2<n1:
    #     return intersect(nums2,nums1)
    
    # for num in nums1:
    #     if num in minDict:
    #         minDict[num] += 1
    #     else:
    #         minDict[num] = 1
    
    # for num in nums2:
    #     if num in minDict:
    #         result.append(num)
    #         minDict[num] -= 1
    #         if minDict[num] == 0:
    #             del minDict[num]
    
    # return result

if __name__ == "__main__":
    nums1 = [1,2,2,1]
    nums2 = [2,2]
    print(intersect(nums1,nums2))