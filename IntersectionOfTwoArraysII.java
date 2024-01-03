import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> li = new ArrayList<>();
        if( n1 > n2) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n1; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }

        for(int i = 0; i < n2; i++){
            if(map.containsKey(nums2[i])){
                li.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                map.remove(nums2[i], 0);
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
