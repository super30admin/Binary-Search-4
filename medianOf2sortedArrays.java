//time comlexity O(log n) where n is the length of smaller array
//space complexity O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0; int high = n1;
        while(low <= high){
            int pX = low + (high - low)/2;
            int pY = (n1+n2+1)/2 - pX;
            double l1 = pX == 0 ? Integer.MIN_VALUE : nums1[pX - 1];
            double r1 = pX == n1 ? Integer.MAX_VALUE : nums1[pX];
            double l2 = pY == 0 ? Integer.MIN_VALUE : nums2[pY - 1];
            double r2 = pY == n2 ? Integer.MAX_VALUE : nums2[pY];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 != 0){
                    return Math.max(l1, l2);
                } else{
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
            } else if(l1 > r2){
                high = pX - 1;
            } else {
                low = pX + 1;
            }
        }
        return -1;
    }
}
