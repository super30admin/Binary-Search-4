import java.util.Arrays;

/*
Intuition behind this is to perform binary search on the number of partitions instead of the values themselves.
For ex, if nums1 = {1,2,3,4} is treated as | 1 | 2 | 3 | 4 | where each '|' is a partition and is assigned an index.
So the total number of partitions in the above example is 5 which is always length + 1 and the indices of all partitions
are 0-4 where the final partition's index is the same as that of length of the array.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1); //making sure to always have lesser length in n1

        int left = 0; //initial left
        int right = n1; //initial right is at the last partition of n1 i.e., length of n1
        int partition1; //the partition line in nums1
        int partition2; //the partition line in nums2

        //the L1 and L2 are left side elements of both arrays and similarly, R1 and R2 are of right side
        int L1; int L2; int R1; int R2;
        int halfOfTotalCount = (n1 + n2 + 1) / 2; //splitting partitions and not regular indices, hence add 1

        while(left <= right) { //B.S, O(log(min(n,m)) T.C, O(1) S.C
            partition1 = left + (right - left) / 2; //similar to find mid
            //At any point, each partition should contain exactly(possibly +1) half of total elements m+n.
            //So to find partition2, we simply subtract the partition1 value with earlier found total half-count.
            partition2 = halfOfTotalCount - partition1;

            L1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1]; //boundary adjusted
            R1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            L2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            R2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];

            //similar to mid == target
            if(L1 <= R2 && L2 <= R1) { //if the elements on the left are smaller than the crossed elements on the right
                if((n1 + n2) % 2 == 0) { //even case
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0; //take average of two middle's
                }
                else return Math.max(L1, L2); //odd case, return the max on left side.
            } else if (L1 > R2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,70,90};
        int[] nums2 = {2,4,60};

        System.out.println("The median of arrays " + Arrays.toString(nums1) + " and " +
                        Arrays.toString(nums2) + " is: " + findMedianSortedArrays(nums1, nums2));
    }
}
