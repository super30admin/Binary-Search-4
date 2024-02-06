class Solution {
    //Tc: O(log n1) --->  n1 length of the array1(smaller array)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1.length == 0 && nums2.length == 0) return 0.0;
         int n1 = nums1.length;

        int n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;

        while (low <= high) {
            int partX = low + ((high - low) / 2);

            int partY = ((n1 + n2) / 2) - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];

            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];

            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                // correct partition
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }

            } else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }

        return -1;
    }
}