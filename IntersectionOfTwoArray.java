// Intersection of Two Arrays II
// Time Complexity : O(n log m), 
// where n is the length of the smaller array and m is the length of the larger array
// Space Complexity : O(k), 
// where k is the size of the list )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
