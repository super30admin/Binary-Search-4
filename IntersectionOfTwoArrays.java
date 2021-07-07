// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map1 =  new HashMap<>();
            HashMap<Integer, Integer> map2 =  new HashMap<>();

            List<Integer> list = new ArrayList<>();

            for(int i : nums1){
                map1.put(i, map1.getOrDefault(i,0) + 1);
            }

            for(int i : nums2){
                map2.put(i, map2.getOrDefault(i,0) + 1);
            }

            int a;
            int b;

            for(int key : map1.keySet()){
                a = map1.get(key);

                if(map2.containsKey(key)){
                    b = map2.get(key);
                } else {
                    b = 0;
                }

                int c = Math.min(a,b);

                for(int i= 0; i < c; i++){
                    list.add(key);
                }
            }

            int[] r = new int[list.size()];

            for(int i = 0; i < list.size(); i++){
                r[i] = list.get(i);
            }

            return r;
        }
    }
}
