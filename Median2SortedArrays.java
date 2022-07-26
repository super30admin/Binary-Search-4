/*
This approach solves the problem using a unique partitioning approach, combined with binary search. The arrays are split
into partitions, and then a midpoint of these partitions is taken in such a way that:

1. The number before the midpoint partition on the first array is less than the number after the midpoint partition on the second array.
2. The number before the midpoint partition on the second array is less than the number after the midpoint partition on the first array.

These two rules allow us to keep consistent with the logic that the median on the two arrays has to lie at the true midpoint partition
of both the arrays, which is when both left partitions will be lesser than both the right partitions. We use binary search to find the
true midpoint partition this way

Did this code run on leetcode: Yes
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        
        while(low <= high)
        {
            int xp = low + (high - low) / 2;
            //We use a formula to calculate the midpoint partition for the second array, which is dependent upon the first midpoint partition
            int yp = (n1 + n2) / 2 - xp;
            
            //If the partitions are at the edges then we set the values as +/- infinity, otherwise we take the value in the cell before the partition
            double l1 = xp == 0 ? Integer.MIN_VALUE : nums1[xp - 1];
            double l2 = yp == 0 ? Integer.MIN_VALUE : nums2[yp - 1];
            double r1 = xp == n1 ? Integer.MAX_VALUE : nums1[xp];
            double r2 = yp == n2 ? Integer.MAX_VALUE : nums2[yp];
            
            if(l1 <= r2 && l2 <= r1)
            {   //If the total number of elements is even, the median is calculated by taking the average of the values around the true midpoint
                if((n1 + n2) % 2 == 0)
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2;
                //If the total number of elements is odd, we simply return the middle element, which in this case lies to the right of the true
                //midpoint partition, as in our calculations we have taken one less element in the left partition
                else
                    return Math.min(r1, r2);
            }
            
            else if(l2 > r1)
                low = xp + 1;
            
            else
                high = xp - 1;
        }
        
        return 0.00;
    }
}