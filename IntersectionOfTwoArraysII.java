//The approach here is to store the frequency of elements of an array in a Hashmap and then iterate through another array to see if any element in this array exists in the hashmap.
//If exists, then add to result and decrease the frequency of that element in the hashmap.
//Time Complexity: O(n1 + n2), where n1 and n2 are the lengths of two arrays
//Space Complexity: O(min(n1, n2));
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(nums1 == null || nums2 == null || n1 == 0 || n2 == 0){
            return null;
        }
        if(n1 > n2){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] re = new int[li.size()];
        for(int i = 0; i<re.length; i++){
            re[i] = li.get(i);
        }
        return re;
    }
}
