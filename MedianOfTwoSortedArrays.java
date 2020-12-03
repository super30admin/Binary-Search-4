//time complexity-  O(log(Math.min(n1,n2))
//space complexity- O(1)
import java.util.Arrays;
public class MedianOfTwoSortedArrays {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = n1;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (total + 1) / 2 - partX;

            int x1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int y1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int x2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int y2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (x1 <= y2 && x2 <= y1) {
                if (total % 2 == 0) {
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2.0;
                } else {
                    return Math.max(x1, x2);
                }
            } else if (x1 > y2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        return 0.0;
    }
    public static void main(String[] args) {
        int[]nums1 = {1, 2};
        int[]nums2 = {3, 4};

        System.out.println("Meadian of array1 " + Arrays.toString(nums1) + " and array2 " + Arrays.toString(nums2) + " is : " + findMedianSortedArrays(nums1, nums2));
    }
}
