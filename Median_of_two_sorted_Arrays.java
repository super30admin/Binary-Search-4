// Time Complexity - O(log(n)), n is the length of shorter array
// Space Coplexity - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int low = 0;
        int high = n1;

        while(low <= high){
            int partx = low + (high - low) / 2;
            int party = n / 2 - partx;

            // base case
            double x1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
            double x2 = party == 0 ? Integer.MIN_VALUE : nums2[party - 1];
            double y1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            double y2 = party == n2 ? Integer.MAX_VALUE : nums2[party];

            if(x1 <= y2 && x2 <= y1){
                // corect partion
                if(n % 2 == 0){
                    return (Math.min(y1,y2) + Math.max(x1, x2))/2;
                }else {
                    return Math.min(y1,y2);
                }
            }else if(x1 > y2){
                high = partx - 1;
            }else{
                low = partx + 1;
            }
        }
        return 0.00;
    }
}
