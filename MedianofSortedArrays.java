/*
* Approach:
*  1. Get the smaller length array into nums1 and 
        start finding the correct partition using binary search.
    
        if partition1 is found, 
            partition2 = total length - partition1 (both even and odd cases)
* 
*  2. Check whether the partitions are correct or not,
        by comparing the left elements(l1, l2) and right elements(r1, r2)
        l1 < r1 and l2 < r2 is always true(as array is sorted)

        l1 <= r2 and l2 <= r1 -> all the elements in left are less than right
        (correct partition)
    
        if l1 <= r2 and l2 > r1 => we should move the paritition to right
                low = partition+1
        else:
            high = parition-1
* 
*  3. if correct: check the combined length,
        if even: return avg of max(l1, l2) and min(r1, r2)
        odd: return min(r1,r2)
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(log(min(m,n)))
* 
* Space Complexity: O(1)
* 
*/

class MedianofSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;

        int n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;

        while (low <= high) {
            int partition1 = low + ((high - low) / 2);

            int partition2 = ((n1 + n2) / 2) - partition1;

            int l1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];

            int r1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];

            int l2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];

            int r2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];

            if (l1 <= r2 && l2 <= r1) {
                // correct partition
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.min(r1, r2);
                }

            } else if (l1 <= r2) {
                low = partition1 + 1;
            } else {
                high = partition1 - 1;
            }
        }

        return -1;
    }
}