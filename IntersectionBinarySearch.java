/*
* Approach:
*  1. Take the smaller array and iterate over the elements.
* 
*  2. Apply binary search(first occurence finding) in other array,
    if found, 
        add the element to result and 
        update the start of next binary search to foundindex+1
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(mlogn) - assuming sorting is discarded.
    m - length of smaller array
    n - length of larger array
* 
* Space Complexity: O(1)
* 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionBinarySearch {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> intersection = new ArrayList<>();
        int start = 0;

        for (int index = 0; index < nums1.length; index++) {
            int idx = binarySearch(nums2, nums1[index], start);

            if (idx != -1) {
                intersection.add(nums1[index]);
                start = idx + 1;
            }
        }

        int[] result = new int[intersection.size()];

        for (int index = 0; index < intersection.size(); index++) {
            result[index] = intersection.get(index);
        }

        return result;
    }

    private int binarySearch(int[] nums, int target, int start) {
        int low = start, high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target) {
                if (mid == low || nums[mid] > nums[mid - 1])
                    return mid;
                else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
