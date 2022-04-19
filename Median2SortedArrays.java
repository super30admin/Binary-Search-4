//Time Complexity : O(log n) n is size of smaller array in input
//Space Complexity : constant

class Solution {

    /* We run binary search on the smaller array to find the correct partitions on both arrays such that the combined partition gives us median
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        //forcing the first argument to always be smaller
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        //low, high, mid pointers are put on partitions of smaller array(X)

        int low = 0;
        int high = n1;

        while(low <= high)
        {
            //mid
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;

            //we combine the arrays and put an imaginary single partition

            //last element of X on left side
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            //first element of X on right side
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            //last element of Y on left side
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            //first element of X on right side
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            //compare these value to check if this partition is valid

            if(L1 <= R2 && L2 <= R1) //correct partition
            {
                if((n1+n2) % 2 == 0) //even elements
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2;
                else //odd elements
                    return Math.min(R1,R2);
            }
            else if(L1 > R2)
                high = partX - 1;
            else
                low = partX + 1;
        }

        return 8.99;

    }
}
