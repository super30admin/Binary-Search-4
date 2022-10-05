import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

Time Complexity :   O (n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (350. Intersection of Two Arrays II)
Any problem you faced while coding this :       No
 */
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
    
class IntersectOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // create a HashMap with number and its count for nums2
        for(int i = 0; i< nums2.length; i++){
            if(!map.containsKey(nums2[i])){
                map.put(nums2[i], 1);
            }
            else{
                map.put(nums2[i], map.get(nums2[i])+1);
            }
        }

        // travel num1
        for(int i = 0; i< nums1.length; i++){
            // check if number present in map
            // if present add into result list and subtract the count from map
            if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0){
                list.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i])-1);
            }
        }
        int[] result = new int[list.size()];
        int k=0;
        for(int i = 0; i< list.size(); i++){
            result[k] = list.get(i);
            k++;
        }
        return result;
    }
}
