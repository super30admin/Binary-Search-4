# tc O(log m), sc O(1).
m = len(nums1)
n = len(nums2)

if (m+n) % 2 == 0:
    k = (m+n) // 2
else:
    k = (m+n) // 2 + 1

def get(a, idx):
    if idx < 0:
        return float("-inf")
    if idx >= len(a):
        return float("inf")
    return a[idx]

start, end = 0, m - 1
while start <= end:
    mid = start + ((end - start) // 2)
    if get(nums2, k-1-mid-1) <= get(nums1, mid) <= get(nums2, k-1-mid):
        kth = get(nums1, mid)
        succ = min(get(nums1, mid+1), get(nums2, k-1-mid))
        break
    elif get(nums1, mid) > get(nums2, k-1-mid):
        end = mid - 1
    else:
        start = mid + 1

if start == end + 1:
    kth = get(nums2, k-start-1)
    succ = min(get(nums1, start), get(nums2, k-start))

if (m+n) % 2 == 0:
    return (kth + succ) / 2
else:
    return kth
