// TC: O ( min(log n1, log n2) )
// SC: O(1)

public class MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length; // X array len
        int n = nums2.length; // Y array len
        // X should always be the smaller array
        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = m;
        while (left <= right) {
            // x partition
            int partX = (left + right) / 2;
            // y partition = total elems/2 - x partition
            int partY = (m + n) / 2 - partX;
            // find the elements on either side of these partitions
            double LX = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double RX = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double LY = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double RY = partY == n ? Integer.MAX_VALUE : nums2[partY];
            // if the partitions divide the elements correctly
            if(LX <= RY && LY <= RX) {
                if ((m + n) % 2 == 0) {
                    //even number of elems
                    return (Math.max(LX, LY) + Math.min(RX, RY)) / 2.0;
                } else {
                    //odd number of elems
                    return Math.min(RX, RY);
                }
            } else if (LX > RY) {
                right = partX - 1; // move left if LX > RY
            } else if (LY > RX) {
                left = partX + 1; // move right if LY > RX
            }
        }
        return -1.0; // should never reach here
    }
}
