# Time Complexity: O(log(m+n))
# space Complexity: O(1)
class Solution:
    #     we will consider the longer length array and initialize two pointers as start and end
    #     index of the selected array we will iterate over the arrays considering the
    #     partition of both the arrays and now we will consider the left side right most
    #     element and right side left most element in both the arrays after partition
    #     as given array are sorted we only need to cross check the 4 values l1, l2, r1, r2
    #     we will check l2 with r1 and l1 with r2 , if in range iit is correct
    #     partition if not we will move pointers accordingly
    #     if correct partition , depending upon size of the array even/odd we will
    #     take max and min from left and right respectively and take mid of that else will take min of right side only
    def findMedianSortedArrays(self, nums1, nums2):
        n = len(nums1)
        m = len(nums2)

        if n > m:
            return self.findMedianSortedArrays(nums2, nums1)

        low = 0
        high = n

        while low <= high:
            partx = int(low + (high - low) / 2)
            party = int((n + m) / 2 - partx)

            l1 = float("-inf") if partx == 0 else nums1[partx - 1]
            r1 = float("inf") if partx == n else nums1[partx]
            l2 = float("-inf") if party == 0 else nums2[party - 1]
            r2 = float("inf") if party == m else nums2[party]

            if l1 <= r2 and l2 <= r1:

                if (n + m) % 2 == 0:
                    return (max(l1, l2) + min(r1, r2)) / 2
                else:
                    return min(r1, r2)


            elif l2 > r1:
                low = partx + 1
            else:
                high = partx - 1

        return 1.00
