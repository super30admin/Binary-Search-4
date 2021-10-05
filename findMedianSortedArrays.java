// Time Complexity - O(log(Min(n,m))) where n and m is the size of the input
// Space Complexity - O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = nums1.length;

        while(low<=high){
            int num1MidPartition = low + (high-low)/2;
            int num2MidPartition = (nums1.length+nums2.length)/2 - num1MidPartition;

            double l1 = num1MidPartition == 0 ? Integer.MIN_VALUE : nums1[num1MidPartition-1];
            double r1 = num1MidPartition == nums1.length ? Integer.MAX_VALUE : nums1[num1MidPartition];
            double l2 = num2MidPartition == 0 ? Integer.MIN_VALUE : nums2[num2MidPartition-1];
            double r2 = num2MidPartition == nums2.length ? Integer.MAX_VALUE : nums2[num2MidPartition];
                
            if(l1<=r2 && l2<=r1){
                if((nums1.length+nums2.length)%2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
                else{
                    return Math.min(r1, r2);
                }
            }
            else if(l1 > r2){
                high = num1MidPartition-1;
            }
            else{
                low = num1MidPartition+1;
            }
        }

        return -1;
    }
};