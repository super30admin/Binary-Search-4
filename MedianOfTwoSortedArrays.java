// Time Complexity : O(logm) => where m is the length of smaller array on which we perform binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using virtual partinioning. Perform binary search on smaller array. Start low with 0 and hight with length of smaller array. Then run a while loop for low <=high, calculate partX to decide the partition on smaller array which will be low + (high-low)/2 and partY will be (m+n)/2 - partX to decide partition on other array. Now we need to calculte l1, r1, l2, r2 and check always l1 <=r2 && l2 <= r1 to ensure if we selected right partition (We don't check l1 <= r1 & l2 <= r2 as arrays are sorted and this will always hold true). If condition satisfied depending on odd or even calculate the median but if l1 > r2 then move high else move low
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null && nums2 == null){
            return 0.0;
        }

        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while(low <=high){
            int partX = low + (high-low)/2; //To prevent integer overflow
            int partY = (m+n)/2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX -1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1){
                //To handle scenarios where length of combined array is even
                if((m+n) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1, r2))/2;
                }
                //To handle scenarios where length of combined array is odd
                return Math.min(r1, r2);
            }
            else if(l1 > r2){
                high = partX -1;
            }
            else{
                low = partX + 1;
            }
        }

        return 0.0;
    }
}