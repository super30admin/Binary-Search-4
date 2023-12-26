// Time Complexity : O(m+n) if given sorted array or else mlogm+nlogn for sorting
// Space Complexity : O(m,n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        if (nums1.length < nums2.length)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pointer1 = 0;
        int pointer2 = 0;

        List<Integer> res = new ArrayList<>();

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                res.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }

        int[] resArray = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            resArray[j] = res.get(j);
        }

        return resArray;
    }

    public static void main(String[] args) {
        Problem1 solution = new Problem1();

        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = solution.intersect(nums1, nums2);

        System.out.println("Intersection of arrays: " + Arrays.toString(result));
    }
}
