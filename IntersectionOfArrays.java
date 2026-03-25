import java.util.*;


// O(n+m) time, O(min(n,m)) space
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1 approach put 1 array in frequency hashmap
        // then while traversing 2nd array, check freq, add to ans arr and decrement freq, if freq = 0, remove from map

        int n = nums1.length;
        int m = nums2.length;

        List<Integer> curr = new ArrayList<>();

        // take minimum length array
        if (n > m) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                curr.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }

        int[] ans = new int[curr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = curr.get(i);
        }
        return ans;

    }
}