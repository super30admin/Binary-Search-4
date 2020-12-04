/**
 * Solution 1: Crude Attempt
 * LeetCode Execution: One test case missed but rectified later. Runtime -> 56.45%, Memory Usage: 83.87% :-(
 * 
 * Missed TestCase:  When arrays of equal length my comparion was not working efficiently
 * 
 * Time Complexity: O(n + m); Where n being the length of the larger Array & m being the length of smaller Array
 * Space Complexity: O(m)
 * 
 * Approach: HashMap
 * 
 */

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      
      Map<Integer, Integer> counter = new HashMap<>();
      
      for (int i : nums1.length >= nums2.length ? nums2 : nums1) {
          counter.put(i, counter.getOrDefault(i, 0) + 1);
      }
      
      List<Integer> result = new ArrayList<>();
      if (counter.size() > 0) {
          for (int i: nums1.length < nums2.length ? nums2 : nums1){
              if (counter.containsKey(i) && counter.get(i) > 0) {
                  result.add(i);
                  counter.put(i, counter.get(i) - 1);
              }
          }   
      }
      
      int[] res = new int[result.size()];
      int c = 0;
      for (Integer val : result) {
          res[c] = val.intValue();
          c++;
      }
      return res;
      
      
  }
}


/**
 * Solution 2: Better Approach
 * 
 * Binary Search Approach:
 */