// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //find the length of the arrays
        int n1 = nums1.length;
        int n2 = nums2.length;
        //check to find if n1 is smaller if not switch
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        //set low and high pointers for binary search
        int l = 0;
        int h = n1;
        //start the while loop for the binary search
        while(l <= h){
            //partion of n1 find the mid of nums1
            int px = l + (h-l)/2;
            //find the partion of y with formula
            int py = (n1+n2)/2 - px;
            //find the low1 and low2    
            //if the partion is = 0 then set negative infinity
            double l1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            //if the partion is end of array then set to positive infinity
            double r1 = px == n1 ? Integer.MAX_VALUE : nums1[px];
            //same for l2 r2
            //if the partion is = 0 then set negative infinity
            double l2 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            //if the partion is end of array then set to positive infinity
            double r2 = py == n2 ? Integer.MAX_VALUE : nums2[py];
            //if l1 is less than r2 and l2 is less then r1 then return average
            if(l1 <= r2 && l2 <= r1){
                //even
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;      
                }
                //odd
                else{
                    //return min of the r1 or r2
                    return Math.min(r1,r2);
                }
            }
            //l2 greater than r1
            else if(l2 > r1){
                //move low to partion x  + 1
                l = px + 1;
            }
            else{
                //move high to px - 1;
                h = px - 1;
            }
        }
        //return a random big number 
        return 18901.0;
    }
}