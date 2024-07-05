// Time Complexity :
// Space Complexity :  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * 350. Intersection of Two Arrays II
 * 
 */

import java.util.*;

public class IntersectionOfTwoArraysII {

    /*
     * Using Hashmap
     * Time complexity: O(m+n)
     * Space Complexity: O(min(m,n))
     * 
     * Go through the smaller array, put the number and its count in Hashmap(as
     * duplicates are allowed in array, if no duplicates are allowed we could have
     * used HashSet)
     * 
     * go through the bigger array and decrement the count of the element in hashmap
     * and remove if zero.. each time you find a match add it to the result.
     */

    public int[] intersect_1(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return intersect_1(nums2, nums1);

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num : nums1) {
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (cache.containsKey(num)) {
                result.add(num);
                cache.put(num, cache.get(num) - 1);
                cache.remove(num, 0);
            }
        }

        int[] response = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            response[i] = result.get(i);
        }
        return response;
    }

    /*
     * Two pointer approach on sorted Array
     * Time complexity: O(m+n)
     * Space complexity: O(1)
     * 
     * Two pointers point at start of two arrays,
     * if we find a match incremenet both and add it to result
     * if nums1[pointer1] > nums2[pointer2] -> i.e., nums2 has smaller elements so
     * we increment pointer2
     */
    public int[] intersect_2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return intersect_2(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < n1 && pointer2 < n2) {
            if (nums1[pointer1] == nums2[pointer2]) {
                result.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                pointer1++;
            }
        }

        int[] response = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            response[i] = result.get(i);
        }
        return response;

    }
}
