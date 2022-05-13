class Solution:
    '''
    Approach 1: Hash Map
    T = O(N+M) , N, M -> sizes of the respective arrays
    S = O( min(M, N) )
    Algorithm

    1. If nums1 is larger than nums2, swap the arrays.

    2. For each element in nums1:

        Add it to the hash map m.

            Increment the count if the element is already there.
    3. Initialize the insertion pointer (k) with zero.

    4. Iterate along nums2:

        If the current number is in the hash map and count is positive:

            Copy the number into nums1[k], and increment k.

            Decrement the count in the hash map.

    5. Return first k elements of nums1.
    
    Approach 2: Sort
    T = O(NlogN + MlogM)
    S = O(logn+logm) to O(n+m) - DOUBT
    Algorithm

    1. Sort nums1 and nums2.

    2. Initialize i, j and k with zero.

    3. Move indices i along nums1, and j through nums2:

        Increment i if nums1[i] is smaller.

        Increment j if nums2[j] is smaller.

        If numbers are the same, copy the number into nums1[k], and increment i, j and k.

    4. Return first k elements of nums1.
    
    '''
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        i , j = 0 ,0 
        k = 0 
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1 
            elif nums1[i] > nums2[j]:
                j += 1
            elif nums1[i] == nums2[j]:
                # print(k, i )
                nums1[k] = nums1[i]
                k += 1
                i += 1 
                j += 1
        return nums1[:k]
