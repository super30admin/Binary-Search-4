// Time Complexity : O(m + n) --> where n & m are the lengths of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (350): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// HashMap O(m + n) solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // edge case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        if (nums1.length > nums2.length) return intersect(nums2, nums1); // to reduce space
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                ls.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                map.remove(nums2[i], 0);
            } 
        }
        
        int result[] = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) result[i] = ls.get(i);
        return result;
    }
}