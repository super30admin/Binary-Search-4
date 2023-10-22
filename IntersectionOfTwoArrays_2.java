
public class IntersectionOfTwoArrays_2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            intersect(nums2, nums1);
        }
        java.util.List<Integer> result = new java.util.ArrayList<>();

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int number : nums1) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        for (int number2 : nums2) {
            if (map.containsKey(number2) && map.get(number2) > 0) {
                result.add(number2);
                map.put(number2, map.get(number2) - 1);
                if (map.get(number2) == 0) {
                    map.remove(number2);
                }
            }

        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
