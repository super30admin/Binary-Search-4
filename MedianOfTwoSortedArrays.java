class Solution {
    /*
        TC - O(log(min(m, n))), where m and n are the lengths of the two input arrays.
        SC - O(1), as we are using a constant amount of extra space.
        This solution uses binary search on the smaller array to find the correct partition of the two sorted arrays.
        We perform binary search on the smaller array to achieve O(log(min(n1, n2))) time.
        Partition both arrays such that the total number of elements on the left equals the total number on the right (or differs by one for odd total length).
        Let:
        l1, l2 = largest elements on the left of each partition.
        r1, r2 = smallest elements on the right of each partition.
        If l1 <= r2 and l2 <= r1, the correct partition is found:
        Even total elements: Median is the average of max(l1, l2) and min(r1, r2).
        Odd total elements: Median is the smaller of the two right-side elements (min(r1, r2) in this implementation).
        If l2 > r1, move the partition in nums1 to the right (low = partX + 1).
        Otherwise, move it to the left (high = partX - 1).
        Using Integer.MIN_VALUE and Integer.MAX_VALUE handles edge cases where a partition is at the beginning or end of an array.
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];

            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1+n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                else return Math.min(r1, r2);
            } else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }

        return 0.0;
    }
}