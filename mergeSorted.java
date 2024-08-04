/*
TC --> O(logn)
SC --> O(1)
 */
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            findMedianSortedArrays(nums2, nums1);
        }//if

        int n = nums1.length;
        int m = nums2.length;
        int left = 0;
        int right = n;
        int mid;
        int partX;
        int partY;
        int l1;
        int l2;
        int r1;
        int r2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            partX = mid;
            partY = (n + m) / 2 - partX;
            l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            System.out.print(l1 + " " + l2 + " " + r1 + " " + r2);
            if (l1 <= r2 && l2 <= r1) {

                if ((n + m) % 2 == 0) {
                    // System.out.println(Math.min(r1,r2)+Math.max(l1,l2));
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }

            } else if (l1 > r2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }//while
        return 1.000;

    }//method
}//class
