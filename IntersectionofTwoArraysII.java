// Time Complexity: O(m + n)
// Space Complexity: O(min(m + n))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                result.add(num);
                if (map.get(num) == 0) {
                    map.remove(num);

                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}