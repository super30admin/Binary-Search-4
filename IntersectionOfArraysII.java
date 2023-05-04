import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        int m = nums1.length; int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for (int j : nums1) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j)) {
                li.add(j);
                int count = map.get(j) - 1;
                map.put(j, count);
                map.remove(j, 0);
            }
        }

        int[] result = new int[li.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = li.get(i);
        }
        return result;
    }
}
