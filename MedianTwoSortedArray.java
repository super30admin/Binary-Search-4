// Time Complexity : O(log(min(n1,n2)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Using binary search find different partitions in nums1 and correspondingly in nums 2 and check if it leads to sorted array. Then find 
// median on the basis whether total number of elements are even or odd.


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n2 < n1){
            return findMedianSortedArrays(nums2, nums1);
        }

        //we are searching for correct partition
        int lo = 0;
        int hi = n1; // there are n1 partitions and n1-1 indexes

        while( lo <= hi){
            int partX = lo + (hi - lo)/2;
            int partY = (n1 + n2)/2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1){ // correct partition
                if((n1+n2) % 2 == 1){
                    return Math.min(r1,r2);
                }
                else{
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
            }
            else if(l1 > r2){
                hi = partX - 1;
            }
            else{
                lo = partX + 1;
            }
        }

        return 0.0;
    }
}