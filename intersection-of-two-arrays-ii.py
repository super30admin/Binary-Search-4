# tc O(n log n + m log n), sc O(n + m for sorting).
nums1.sort()
nums2.sort()
i = j = 0
result = []

while i < len(nums1) and j < len(nums2):
    if nums1[i] != nums2[j]:
        if nums1[i] < nums2[j]:
            i += 1
        else:
            j += 1
    else:
        result.append(nums1[i])
        i += 1
        j += 1

return result