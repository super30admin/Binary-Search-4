// Time Complexity : O(m + n) where m and n are the lengths of nums1 and nums2 respectively
// Space Complexity : O(n) for storing elements in the hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class intersectionOfArraysLinear {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[] {};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                map.put(i, map.get(i) - 1);
                map.remove(i, 0);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}