/**
 * TC : O(min(log(m,n))) SC : O(1)
 * Approach  : Partition both the arrays and check for the deciding condition, in which direction the next partition should be. 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);
        int x = (nums1.length + nums2.length);
        int low = 0, high = nums1.length;
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int part2 = (x/2) - mid;
            l1 = (mid-1) < 0 ? Integer.MIN_VALUE : nums1[mid-1];
            l2 = (part2-1) < 0 ? Integer.MIN_VALUE : nums2[part2-1];
            r1 = (mid+1) > nums1.length ? Integer.MAX_VALUE : nums1[mid];
            r2 = (part2+1) > nums2.length ? Integer.MAX_VALUE : nums2[part2];
            if(l1 <= r2 && l2 <= r1){
                if(x % 2 == 0){
                    // System.out.println("1 : " + (Math.max(l1,l2) + Math.min(r1,r2)) / 2);
                    double res = (Math.max(l1,l2) + Math.min(r1,r2))/2.00;
                    return res;
                }else {
                    // System.out.println("2 : " + r1 +" "+r2);
                    return Math.min(r1,r2);
                }
            }else if( l2 > r1){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return 0.00;
    }
}