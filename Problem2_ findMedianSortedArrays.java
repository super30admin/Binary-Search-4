class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left = 0;
        int right = nums1.length;
        
        int total = nums1.length + nums2.length;
        int l1 = nums1.length;
        int l2 = nums2.length;

        while(left <= right){
            int mid1 = (left + right) / 2;
            int mid2 = ((total + 1) / 2) - mid1;

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int right1 = mid1 == l1 ? Integer.MAX_VALUE : nums1[mid1];
            int right2 = mid2 == l2 ? Integer.MAX_VALUE : nums2[mid2];

            if(left1 <= right2 && left2 <= right1){
                if(total % 2 == 0){
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                }
                else{
                    return (double)Math.max(left1,left2);
                }
            }
            else if(left1 > right2){
                right = mid1-1;
            }
            else{
                left = mid1+1;
            }
        }
        return 0.0;
    }
}