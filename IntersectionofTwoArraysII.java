import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class IntersectionofTwoArraysII {

    public static void main(String[] args) {
        int[] m = { 1,2,2,1};
        int[] n = { 2,2 };
        IntersectionofTwoArraysII obj = new IntersectionofTwoArraysII();
        int[] obj1 = obj.intersect(m, n);
        System.out.println(Arrays.toString(obj1));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int num : nums1) {
        // map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // for (int num : nums2) {
        // if (map.containsKey(num)) {
        // li.add(num);
        // map.put(num, map.get(num) - 1);
        // map.remove(num, 0);

        // }
        // }
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums2[p2] < nums1[p1]) {
                p2++;
            } else {
                p1++;
            }

        }
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }

        return result;

    }
}
