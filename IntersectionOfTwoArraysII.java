//Time Complexity: O(n1 + n2)
//Space Complexity: O(min(n1, n2))

/* 
 * LeetCode: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Finds the intersection of two integer arrays, allowing duplicate elements.
 * Uses a HashMap to count frequencies in the smaller array and checks matches in the other.
 * Returns an array containing common elements based on minimum frequency in both arrays.
 */


public class IntersectionOfTwoArraysII {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length; 
            int n2 = nums2.length; 
    
            if(n1 > n2) {
                intersect(nums2, nums1);
            }
    
            HashMap<Integer, Integer> map = new HashMap<>();
    
            for(int i : nums1) {
                map.put(i, map.getOrDefault(i, 0)+1);
            }
    
            List<Integer> result = new ArrayList<>();
    
            for(int i : nums2) {
                if(map.containsKey(i)) {
                    result.add(i);
                    map.put(i, map.get(i)-1);
                    map.remove(i,0);
                }
            }
    
            int[] re = new int[result.size()];
    
            for(int i = 0; i < result.size() ; i++) {
                re[i] = result.get(i);
            }
            return re;
        }
}
