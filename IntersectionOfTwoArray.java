//Time Complexity :  O(log n)
//Space Complexity :  O(log n)
//Did this code successfully run on Leetcode : Yes

import java.util.*;

public class IntersectionOfTwoArray {

        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int num : nums1){
                map.put(num, map.getOrDefault(num,0)+1);
            }
            List<Integer> ll = new ArrayList<>();
            for (int num : nums2){
                if (map.containsKey(num)){
                    ll.add(num);
                    map.put(num, map.get(num)-1);
                    map.remove(num, 0);
                }
            }
            int[] result = new int[ll.size()];
            int i=0;
            for (int nn : ll){
                result[i]= nn;
                i++;
            }
            return result;
        }
    
}
