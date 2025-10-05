//TC: O(log(min(m,n)), m is the length of smaller array, n is the length of the larger array
//SC: O(1)
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        //always perform binary search on the smaller array
        int low = 0, high = n1 + 1; //partition's is 1 more than the length of the array

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = ((n1 + n2) / 2) - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.min(r1, r2);
            } else if (l1 > r2) high = partX - 1;
            else low = partX + 1;
        }

        return 0.0;
    }
}
