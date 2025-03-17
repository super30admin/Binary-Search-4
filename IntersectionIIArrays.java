// Time Complexity : O(m+n)
// Space Complexity : O(m).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
//arrays are unsorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        
        for(int i=0; i<n; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i]) == 0)
                    map.remove(nums2[i]);
            }
        }
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            res[i] = result.get(i);
        return res;
    }
}