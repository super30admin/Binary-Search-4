/* 
Time Complexity: O(m + n) 
   - Build frequency map on smaller array, then scan the other.

Space Complexity: O(min(m, n)) 
   - Frequency map sized by the smaller array.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Ensure nums1 is the smaller array (swap if needed).
// 2. Build a frequency map for nums1.
// 3. Scan nums2; if a number exists in the map with count > 0, add to result and decrement count.
// 4. Convert the result list to an array and return.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOf2ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num, 0);
            }
        }

        int[] re = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            re[i] = result.get(i);
        }

        return re;
    }
}
