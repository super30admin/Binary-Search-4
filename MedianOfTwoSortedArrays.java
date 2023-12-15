// TC : O( log(min(m,n)) )
// SC : O(1)

package S30_Codes.Binary_Search_4;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        int combineLen = nums1Len + nums2Len;
        int halfLen = combineLen / 2;

        int start = 0;
        int end = nums1Len;

        while(start <= end){
            int nums1Ele = start + (end-start)/2;
            int nums2Ele = halfLen - nums1Ele;

            int l1 = nums1Ele == 0 ? Integer.MIN_VALUE : nums1[nums1Ele-1];
            int l2 = nums2Ele == 0 ? Integer.MIN_VALUE : nums2[nums2Ele-1];

            int r1 = nums1Ele == nums1Len ? Integer.MAX_VALUE : nums1[nums1Ele];
            int r2 = nums2Ele == nums2Len ? Integer.MAX_VALUE  : nums2[nums2Ele];

            if(l1 <= r2 && l2 <= r1){
                if(combineLen % 2 == 0){
                    double numOne = Math.max(l1, l2);
                    double numTwo = Math.min(r1, r2);

                    return (numOne + numTwo) / 2;
                }
                else
                    return Math.min(r1, r2);
            }
            else if(l1 > r2){
                end = nums1Ele-1;
            }
            else{
                start = nums1Ele+1;
            }
        }
        return 0;
    }
}