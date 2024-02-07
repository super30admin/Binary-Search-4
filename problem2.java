// Time Complexity : O(log n1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Use partitions and check if the elements on either side of it are less than the others.
If odd, use min elements on right of the partition. 
If even, add max of partition to the left and min of partitions to the right and divide by 2.
 */


class problem2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0){
            return 0.0;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low +(high - low)/2;
            int partY = (n1+n2)/2 - partX;
            int L1 = partX == 0? Integer.MIN_VALUE:nums1[partX-1];
            int R1 = partX == n1? Integer.MAX_VALUE:nums1[partX];
            int L2 = partY == 0? Integer.MIN_VALUE:nums2[partY-1];
            int R2 = partY == n2? Integer.MAX_VALUE:nums2[partY];
            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;
                }
                else {
                    return Math.min(R1, R2);
                }
            }
            else if(L1 > R2){
                high = partX - 1;
            }
            else {
                low = partX + 1;
            }
        }
        return 1.0;
    }
}