package BinarySearch4;

public class question92_MedianOfTwoSortedArrays {
    /* Created by palak on 7/9/2021 */

    /*
        Time Complexity: O(log m) //log of the smaller array
        Space Complexity: O(1)
    */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1; // since we are doing the binary search on the partitions and not on the elements.
        while(low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1) {
                //correct partition which means all the left elements are smaller than the right elements. Find median.
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if(L2 > R1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,5,9,10,15};
        int[] nums2 = new int[]{2,11,12,13,14,16};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums3 = new int[]{1,7,8,10,11};
        int[] nums4 = new int[]{2,3,4,5,6,12,13};
        System.out.println(findMedianSortedArrays(nums3, nums4));

    }
}
