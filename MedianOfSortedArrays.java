// Time Complexity : O(log(n))
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        //binary search
        int l = 0;
        int h = n1;
        //start the while loop for the binary search
        while(l <= h){
            //partion of n1
            int px = l + (h-l)/2;
            //partion of y
            int py = (n1+n2)/2 - px;


            //ifpartion is 0 set to negative infinity
            double l1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            //if the partion is end set to positive infinity
            double r1 = px == n1 ? Integer.MAX_VALUE : nums1[px];
            //same as above
            double l2 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            double r2 = py == n2 ? Integer.MAX_VALUE : nums2[py];


            //if l1 is less than r2 and l2 is less then r1 then return average
            if(l1 <= r2 && l2 <= r1){
                //even
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                //odd
                else{
                    return Math.min(r1,r2);
                }
            }
            //l2 greater than r1
            else if(l2 > r1){
                l = px + 1;
            }
            else{
                h = px - 1;
            }
        }
        //return a random big number
        return 37455.0;
    }
}