import java.util.*;

/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(n) n is the length of the smaller array
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}
