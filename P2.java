/*
Time Complexity (TC)
O(log(min(n, m))) - We perform binary search on the smaller of the two arrays, reducing the search space in half at each step.

Space Complexity (SC)
O(1) - We use a constant amount of extra space.

Explanation of the Code in Three Sentences
The algorithm finds the median of two sorted arrays by performing a binary search on the smaller array, ensuring that the left half and right half are properly partitioned. 
It adjusts the partition until the maximum of the left side is less than or equal to the minimum of the right side, ensuring a valid median split. 
Depending on the total length of the combined arrays, it returns either the average of the two middle elements (even length) or the middle element (odd length).
 */

 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m)
            return findMedianSortedArrays(nums2, nums1);
        
        int l = 0;
        int u = n;

        while(l <= u)
        {
            int partitionX = l + (u - l) / 2;
            int partitionY = (n + m + 1) / 2 - partitionX;

            int leftMaxX = (partitionX == 0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int leftMaxY = (partitionY == 0)? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightMinX = (partitionX == n) ? Integer.MAX_VALUE : nums1[partitionX];
            int rightMinY = (partitionY == m) ? Integer.MAX_VALUE : nums2[partitionY];

            // check the validity of the partition
            if(leftMaxX <= rightMinY && leftMaxY <= rightMinX)
            {
                if((n + m) % 2 == 0)
                    return (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY)) / 2.0;
                else
                    return Math.max(leftMaxX, leftMaxY) * 1.0;
            }
            else if(leftMaxX > rightMinY)
                u = partitionX - 1;
            else
                l = partitionX + 1;
        }
        return 0.0;
    }
}