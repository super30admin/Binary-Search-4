// Time Complexity : O(m + n), where m and n are the lengths of the two input arrays
// Space Complexity : O(min(m, n)), for storing elements of the smaller array in the HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Always build the HashMap on the smaller array to save space.
//   - Store the frequency of each element from the smaller array.
//   - Traverse the second array and if the element exists in the HashMap, add it to the result and decrease the count.
//   - Remove the element from the HashMap when its count reaches zero.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int n: nums1) {
            hmap.put(n, hmap.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int num: nums2) {
            if(hmap.containsKey(num)) {
                result.add(num);
                hmap.put(num, hmap.get(num) - 1);
                hmap.remove(num, 0);    //this removes the num as key if its frequency becomes 0
            }
        }

        int[] output = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        int[] result = solution.intersect(nums1, nums2);

        System.out.println("Intersection of two arrays:");
        printArray(result);
    }
}
