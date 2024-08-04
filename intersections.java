
class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] large = nums1.length >= nums2.length ? nums1 : nums2;

        for (int element : large) {

            if (!map.containsKey(element)) {
                map.put(element, 0);
            }

            map.put(element, map.get(element) + 1);
        }

        if (nums1.length >= nums2.length) {
            return setIntersect(nums2, map);
        } else {
            return setIntersect(nums1, map);
        }
    }

    private int[] setIntersect(int[] nums, Map<Integer, Integer> map) {

        int[] result = new int[nums.length];
        int index = 0;
        for (int element : nums) {

            if (map.containsKey(element)) {
                result[index++] = element;

                map.put(element, map.get(element) - 1);

                if (map.get(element) == 0) {
                    map.remove(element);
                }
            }
        }

        return Arrays.copyOf(result, index);
    }
}
