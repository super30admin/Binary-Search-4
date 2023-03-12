/*
Median of two arrays
approach: Find potential median using l1, l2, r1, r2
time: O(len (smaller array))
space: O(1)
 */
public class Problem2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);
        if(nums1==null || nums2==null) return 0.000;
        int l = 0, h = nums1.length;
        int total = nums1.length+nums2.length;
        while(l<=h) {
            int partX = l+(h-l)/2;
            double l1 = partX==0?Integer.MIN_VALUE:nums1[partX-1];
            double r1 = partX==nums1.length?Integer.MAX_VALUE:nums1[partX];
            int partY = (total)/2-partX;

            double l2 = partY==0?Integer.MIN_VALUE:nums2[partY-1];
            double r2 = partY==nums2.length?Integer.MAX_VALUE:nums2[partY];

            if(l1<=r2 && l2<=r1) {
                if(total%2==0) {
                    return (Math.max(l1, l2)+Math.min(r1, r2))/2;
                }
                else return Math.min(r1, r2);
            }
            else if(l2>r1) {
                l = partX+1;
            }
            else {
                h = partX-1;
            }


        }
        return 8.555;
    }
}
