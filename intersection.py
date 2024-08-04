from collections import Counter
def intersection(nums1, nums2):
    count_map = Counter(nums1)

    res = []

    for num in nums2:
        if count_map[num]>0:
            res.append(num)
            count_map[num]-=1
    return res

nums1 = [1,2,3,4,5]
nums2 = [2,3,4,5]
print(intersection(nums1 , nums2))

# time = O(m+n)
# space = O(min(m,n))