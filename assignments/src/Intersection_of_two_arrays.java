// Time: O(m + n)
// Space: O(min(n,m))

import java.util.*;

class Intersection_of_two_arrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        // to assume nums1 is always smaller than nums2
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for(int n : nums1) {
            hm.put(n, hm.getOrDefault(n,0)+1);
        }
        int k = 0;
        for (int n : nums2) {
            int count = hm.getOrDefault(n,0);
            if (count > 0) {
                nums1[k++] = n;
                hm.put(n, count-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}