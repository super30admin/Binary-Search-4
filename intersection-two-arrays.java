// Time Complexity :O(m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return new int[0];
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                list.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }
            map.remove(nums1[i], 0);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
