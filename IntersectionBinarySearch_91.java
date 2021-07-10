// Time Complexity : O(nlog(m)), where m & n are the size of two arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch4;

import java.util.*;

public class IntersectionBinarySearch_91 {

    public int[] intersect(int[] nums1, int[] nums2) {
        //binary search solution
        int n1 = nums1.length;
        int n2 = nums2.length;
        //if nums1 length is > nums2 then swap nums1 and nums2 
        //to always have the nums1 smaller length
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0, high = n2 - 1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int curr = nums1[i];
            int bSIndex = bSIndex(nums2, low, high, curr);
            if (bSIndex != -1) {
                res.add(curr);
                low = bSIndex + 1;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bSIndex(int[] nums2, int low, int high, int curr) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums2[mid] == curr) {
                if (mid == low || nums2[mid] > nums2[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums2[mid] > curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
