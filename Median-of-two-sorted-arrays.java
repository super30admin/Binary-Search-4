//time - O(log(min(m,n)))
//space - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;

        int low = 0, high = nums1.length;

        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (m+n)/2 - partX;

            double l1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX==m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY==n ? Integer.MAX_VALUE : nums2[partY];

            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                else{
                    return Math.min(r1,r2);
                }
            }
            else if(l1 > r2){
                high = partX-1;
            }
            else{
                low = partX + 1;
            }
        }

        return 8102.32;
    }
}
