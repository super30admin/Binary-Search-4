//Time complexity: O(N)
//Space complexity: O(N)

import java.util.*;

class intersectMapApproach {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.length == 0)
            return nums1;
        
        if(nums2 == null || nums2.length == 0)
            return nums2;
        
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
            
        List<Integer> list = new ArrayList<>();
            
        for(int i = 0; i < n2; i++){
            if(map.containsKey(nums2[i])){
                //update map

                map.put(nums2[i], map.get(nums2[i]) - 1);
                list.add(nums2[i]);
                    
                    
                    //remove from map if count is 0
                    if(map.get(nums2[i]) == 0){
                        map.remove(nums2[i]);
                    }
                }
            }
            
            int[] result = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i);
            }
        
        return result;
    }
}