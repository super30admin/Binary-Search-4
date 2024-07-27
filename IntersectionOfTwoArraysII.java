import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return new int[] {};
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int m = nums2.length;

        if(m < n) {
            return intersect(nums2, nums1);
        }

        for(int i=0; i<n; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for(int i=0; i<m; i++) {
            if(map.containsKey(nums2[i])) {
                result.add(nums2[i]);
                int count = map.get(nums2[i]);
                count--;
                if(count > 0) {
                    map.put(nums2[i], count);
                } else {
                    map.remove(nums2[i]);
                }
            }
        }

        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}