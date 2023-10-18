class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return -1.0;
        }

        int m = nums1.length;
        int n = nums2.length;
        if(n < m){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = m;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (m+n)/2 - partX;
            double left1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double left2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double right1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double right2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            if(left1 <= right2 && left2 <= right1){
                if( (m+n) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }
                return Math.min(right1, right2);
            }
            if(left2 > right1){
                low = partX + 1;
            }
            else if(left1 > right2){
                high = partX - 1;
            }
        }
        return 12553413.45;        
    }
}
