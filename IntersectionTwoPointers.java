/*
* Approach:
*  1. Take two pointers on both the arrays.
        if both elements are equal, 
            add to result and 
            increment both the pointers
        else,
            increment the pointer of lesser element
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m+n)
    m, n - length of both arrays
* 
* Space Complexity: O(1)
* 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionTwoPointers {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;

        List<Integer> intersection = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                intersection.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] result = new int[intersection.size()];

        for (int index = 0; index < intersection.size(); index++) {
            result[index] = intersection.get(index);
        }

        return result;
    }
}
