// approch 1
// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {
    // approch 1
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // make a array of size n1 + n2
        double[] nums = new double[n1 + n2];
        // merge two array by using two pointers O(n) time for merging
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < n1 || p2 < n2) {
            if (p1 == n1) {
                nums[p++] = nums2[p2++];
            } else if (p2 == n2) {
                nums[p++] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                nums[p++] = nums2[p2++];
            } else {
                nums[p++] = nums1[p1++];
            }
        }
        // System.out.println(Arrays.toString(nums));
        int n = nums.length;
        // if n is even return avg of two median
        if (n % 2 == 0) {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2;
        } else {
            // else return median
            return nums[n / 2];
        }
        // return 0.00;
    }

    // approch 2 using binary search and partition
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        // binary search on smaller array
        if (n2 < n1)
            return findMedianSortedArrays2(nums2, nums1);
        int l = 0;
        int r = n1;
        // search on a partition
        while (l <= r) {
            // first array partition on a mid index
            int p1 = l + (r - l) / 2;
            // make partition on a second array such that number of elements on a both side
            // should be same
            int p2 = ((n1 + n2) / 2 - p1);
            // bound check for left side
            double l1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            double l2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];

            // bound check for right side
            double r1 = p1 == n1 ? Integer.MAX_VALUE : nums1[p1];
            double r2 = p2 == n2 ? Integer.MAX_VALUE : nums2[p2];

            // check condition that if l1 < r2 and l2 < r1
            if (l1 <= r2 && l2 <= r1) {
                // check if combined array has even number of element or odd number of elements
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                r = p1 - 1;
            } else {
                l = p1 + 1;
            }

        }
        return 0.00;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 3 };
        int[] nums2 = new int[] { 3, 4 };
        System.out.println(findMedianSortedArrays1(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}