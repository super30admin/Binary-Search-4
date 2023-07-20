//Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        if(n1> n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;
        while(low<=high){
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int l1 = partX==0 ? Integer.MIN_VALUE: nums1[partX-1];
            int r1 = partX==n1 ? Integer.MAX_VALUE: nums1[partX];
            int l2 = partY==0? Integer.MIN_VALUE: nums2[partY-1];
            int r2 = partY==n2 ? Integer.MAX_VALUE: nums2[partY];
            if(l1<=r2 && l2<=r1){
                if(n%2==0){
                    return (Math.max(l1,l2) + Math.min(r1, r2))/2.0;
                }
                return Math.min(r1,r2);
            }
            else if(l1>r2)
                high = partX-1;
            else
                low = partX+1;
        }
        return 0.0;
    }
}