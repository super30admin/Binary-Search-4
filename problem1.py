#intersection of two arrays 
#time complexity: O(M+n) where m and n are the size of two arrays
#space complexity: O(N)
def intersect(self, nums1, nums2):
    """
    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: List[int]
    """
    dict1 = dict()
    for i in nums1:
        if i not in dict1:
            dict1[i] = 1
        else:
            dict1[i] += 1
    ret = []
    for i in nums2:
        if i in dict1 and dict1[i]>0:
            ret.append(i)
            dict1[i] -= 1
    return ret