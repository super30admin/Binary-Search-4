// TC : O(m+n) where m is number elements in smaller array and n is elements of bigger array
// SC : O(m)

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1 == null || nums2 == null)
            return new int[0];

        if(nums1.length < nums2.length){
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        for(int num : nums2){
            map.put(num, map.getOrDefault(num,0) +1);
        }

        List<Integer> li = new ArrayList<>();
        for(int num : nums1){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }

        int[] result = new int[li.size()];
        for(int i=0;i<result.length;i++){
            result[i] = li.get(i);
        }

        return result;
    }
}