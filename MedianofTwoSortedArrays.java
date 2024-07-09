// Time Complexity : O(log m)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Ensure nums1 is the shorter array for efficient binary search.
//Use binary search to partition both arrays into two halves where all elements in the left half are less than or equal to those in the right half.
//Calculate and return the median based on the partitioned halves, considering whether the total length of the arrays is odd or even.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = m;
        while(low<= high){
            int partx = low+(high-low)/2;
            int party = (m+n)/2 - partx;
            double l1 = partx == 0? Integer.MIN_VALUE:nums1[partx-1];
            double l2 = party == 0? Integer.MIN_VALUE:nums2[party-1];
            double r1 = partx == m? Integer.MAX_VALUE:nums1[partx];
            double r2 = party == n? Integer.MAX_VALUE:nums2[party];
            if(l1 <= r2 && l2 <= r1){
                if((m+n)%2 == 0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                return Math.min(r1,r2);
            }
            else if(l1 > r2){
                high = partx - 1;
            }
            else{
                low = partx + 1;
            }
        }
        return -1;
    }
}