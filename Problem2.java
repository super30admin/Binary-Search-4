//binary search
//time o(logn) n is the size of the min i/p array
//space o(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length; int n2 = nums2.length;
        int low =0, high= nums1.length;
        
        while(low<= high) {
            int partX = low + (high-low)/2;
            int partY = (n1+n2+1)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX == nums1.length ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == nums2.length ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1<=r2 && l2<=r1) { //correct partition
                if((n1+n2) % 2 != 0)
                    return Math.max(l1,l2);
                else
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
            }
            else if(l1 > r2) {
                high = partX-1;
            }
            else
                low = partX+1;
        }
        return -1;
    }
}