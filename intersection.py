#As taught iin class using binary search to solve this problem
#Time Complexity: O(logn)
#Space complexity: O(n)
nums1 = [1,2,3]
nums2 = [2]
def intersect(nums1,nums2):
    if (nums1 == None or nums2 == None or len(nums1) == 0 or len(nums2)==0):
        return [0]
    n1 = len(nums1)
    n2 = len(nums2)
    if n1 > n2:
        return intersect(nums2,nums1)
    sorted(nums1)
    sorted(nums2)
    index = 0
    li = list()
    for num in nums1:
        bsindex = binarySearch(nums2,index,n2-1,num)
        if bsindex != -1:
            li.append(num)
            index = bsindex + 1
    result = [0]*len(li)
    for i in range(len(result)):
        result[i] = li[i]
    return result

def binarySearch(nums,low,high,target):
    mid = int((low+high)//2)
    if nums[mid] == target:
        if mid == low or nums[mid] > nums[mid-1]:
            return mid
        else:
            high = mid - 1
    elif nums[mid] > target:
        high = mid - 1
    else:
        low = mid + 1
    return -1

r = intersect(nums1,nums2)
print(r)


