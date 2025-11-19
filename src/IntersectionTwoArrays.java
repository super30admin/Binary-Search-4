import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aditya Sinha
 * Use hashmap
 * Time Complexity - O(m+n)
 * Space Complexity - O(min(m, n))
 */
public class IntersectionTwoArrays {

	public int[] intersect(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficiency
       if (nums1.length > nums2.length) {
           return intersect(nums2, nums1);
       }
       
       Map<Integer, Integer> map = new HashMap<>(); 
       for (int num : nums1) {
           map.put(num, map.getOrDefault(num, 0) + 1); // store smaller array in hashmap with frequency
       }
       
       List<Integer> result = new ArrayList<>();
       for (int num : nums2) { // iterate on larger array
           if (map.containsKey(num) && map.get(num) > 0) { // if it matches
               result.add(num); // add that intersected num in result array
               map.put(num, map.get(num) - 1); // reduce the frequency
           }
       }
       
       // Convert list to array
       int[] res = new int[result.size()];
       for (int i = 0; i < result.size(); i++) {
           res[i] = result.get(i);
       }
       return res;
   }
}
