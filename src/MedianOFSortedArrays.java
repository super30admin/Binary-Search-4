// Time Complexity:    O( log(m+n) )
// Space Complexity:   O(1)
// where m and n are number of elements in arrays
// This code ran successfully on Leetcode

public class MedianOFSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = n1 + n2;
        int half = total / 2;

        int l = 0;
        int r = nums1.length;

        while(l <= r) {
            int mid1 = l + (r-l)/2;
            int mid2 = half - mid1;

            int nums1Left = mid1==0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int nums2Left = mid2==0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int nums1Right = mid1==n1 ? Integer.MAX_VALUE : nums1[mid1];
            int nums2Right = mid2==n2 ? Integer.MAX_VALUE : nums2[mid2];

            if(nums1Left <= nums2Right && nums2Left <= nums1Right) {
                int left = Math.max(nums1Left, nums2Left);
                int right = Math.min(nums1Right, nums2Right);
                if(total % 2 == 1) {
                    return right;
                }
                return (left + right)/2.0;
            } else if(nums1Left > nums2Right) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }
        }
        return -1;
    }
}