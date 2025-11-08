class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        populateMap(map1, nums1);
        populateMap(map2, nums2);

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums1.length;i++) {
            if (map2.containsKey(nums1[i])) {
                result.add(nums1[i]);
                map1.get(nums1[i]).remove(0);
                map2.get(nums1[i]).remove(0);

                if (map1.get(nums1[i]).size() == 0) map1.remove(nums1[i]);
                if (map2.get(nums1[i]).size() == 0) map2.remove(nums1[i]);
            }
        }

        int res[] = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void populateMap(Map<Integer, List<Integer>> map, int[] nums) {
        for (int i = 0; i<nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
}
