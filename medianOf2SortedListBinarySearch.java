// Time Complexity: O(log(m)) where m is size of smaller array
// Space Complexity: O(1)
// Idea here is to partition the arrays correctly based on fact that
// left bucket and right bucket should hold equal number of elements in case of even elements
// else right can have 1 extra value.
// the correct partition should ensure that all the elements on the left are less than
// all the elements on the right in both arrays. We employ binary search for this on partitions
// once we get correct partition point we can return minvalue of right half in odd elements
// and max(left)+min(right)/2 in case of even
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length==0 && nums1.length==0) return 0.0;
        if(nums1.length> nums2.length) return findMedianSortedArrays(nums2, nums1);
        int l = 0; int h = nums1.length;
        while(l<=h) {
            int cut1 = l + (h-l)/2;
            int cut2 = (nums1.length+nums2.length)/2 - cut1;
            double l1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            double l2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
            double r1 = cut1==nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2==nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            if(l1>r2) {
                h = cut1-1;
            } else if(l2>r1) {
                l = cut1+1;
            } else {
                if((nums1.length+nums2.length)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                return Math.min(r1,r2);
            }
        }
        return 0.0;
    }
}