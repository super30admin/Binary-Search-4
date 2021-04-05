// Time Complexity : O(log(min(n,m) , n - nums1 array length, m- nums2 array length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
  
/*
Doing binary search in the smaller array
Then finding the partition of te median finding the min-max in both the partitions
The partition will change based on the min-max until min pointer of the both the array is minimum than the max pointer both the arrays
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        int low = 0,high = n;
        while(low <= high){
            int partX = low+(high-low)/2;
            int partY = (n+m)/2 - partX;
            
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                if((n+m) % 2 ==0)
                    return (Math.min(r1,r2)+Math.max(l1,l2))/2;
                else
                    return Math.min(r1,r2);
            }
            else if(l2>r1){
                low = partX+1;
            }
            else
                high = partX-1;
        }
        return -1;
    }
}
