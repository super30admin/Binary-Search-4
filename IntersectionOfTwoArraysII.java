// Time Complexity : O(len1+len2))
// Space Complexity : O(len1) or O(len2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class IntersectionOfTwoArraysII {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            int len1 = nums1.length;
            int len2 = nums2.length;
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums1) {
                map.put(num, map.getOrDefault(num,0)+1);
            }
            List<Integer> result = new ArrayList<>();
            for(int num : nums2) {
                if(map.containsKey(num))  {
                    result.add(num);
                    map.put(num, map.get(num) -1);
                    map.remove(num, 0);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
