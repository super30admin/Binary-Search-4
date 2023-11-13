// Time Complexity : O(log(n1))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FindMedianTwoSorted {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;

            //let's get smaller array on top for partition
            if(n2 < n1)
                return findMedianSortedArrays(nums2, nums1);

            int low = 0, high = n1;

            while(low <= high){
                int partX = low + (high - low) / 2;
                int partY = ((n1 + n2) / 2) - partX;

                int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
                int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
                int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
                int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

                if(l1 <= r2 && l2 <= r1){
                    //found median
                    if((n1 + n2) % 2 == 0){
                        //even
                        return ((Math.max(l1, l2)) + (Math.min(r1, r2))) / 2.0;
                    }
                    else{
                        //odd
                        return Math.min(r1, r2);
                    }
                }
                else if(l2 > r1){
                    low = partX + 1;
                }
                else{
                    high = partX - 1;
                }
            }
            return 111.111;
        }
    }
}
