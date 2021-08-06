// Time Complexity : O(m+n)
// Space Complexity : O(min(m, n) where m and n are length of input arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length + nums1.length];
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return res;

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int count = map.getOrDefault(n, 0);
            if (count > 0) {
                res[k++] = n;
                map.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}