#As taught in class using binary search for solving this problem
#[WIP] trying to solve the error with loop
#Time complexity: O(logn)
#Space complexity: O(1)
nums1 = [1,3]
nums2 = [2]
def median(nums1,nums2):
    n1 = len(nums1)
    n2 = len(nums2)
    low = 0
    high = n1
    if n1 > n2:
        return median(nums2,nums1)
    while (low <= high):
        x = int((low+high)//2)
        y = (n1+n2)/2 - x
        l1 = 0.0
        if x == 0:
            l1 = -9999
        else:
            l1 = nums1[x-1]
        r1 = 0.0
        if x == n1:
            r1 = 9999
        else:
            r1 = nums1[x]
        l2 = 0.0
        if x == 0:
            l2 = -9999
        else:
            l2 = nums1[y-1]
        r2 = 0.0
        if y == n2:
            r2 = 9999
        else:
            r2 = nums1[x]
        if (l1 <= r2 and l2 <= r1):
            if (n1 + n2)%2 == 0:
                return (max(l1,l2) + min(r1,r2))/2
            else:
                min(r1,r2)
        elif l2 > r1:
            low = x + 1
        else:
            high  = x - 1
    return 1

m = median(nums1,nums2)
print(m)