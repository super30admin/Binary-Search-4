def intersect(nums1, nums2):
    d1, d2 = {}, {}
    ans = []
    for n1 in nums1:
        if n1 in d1: d1[n1] += 1
        else: d1[n1] = 1
    for n2 in nums2:
        if n2 in d2: d2[n2] += 1
        else: d2[n2] = 1
    for k in d1:
        if k in d2:
            for _ in range(min(d1[k], d2[k])): ans.append(k)
    return ans


print(intersect([1,3,3,2,2],[1,2,4,3]))