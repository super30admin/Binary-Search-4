// Time Complexity : O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we using a hashmap to the insersection
 * 
 * In the start we make sure n1 is a smaller array
 * 
 * make the map out of n1, actual number as a key and num of occurance as value
 * 
 * then loop over all the element of n2 and and check if that element is present in the map if yes, we add that element to
 * the list and reduce the count on that elemnt by one
 * if count becomes 0 we remove it
 * 
 * in the end we create an array by irrerate over the map
 * 
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
            if (map.size() == 0) {
                break;
            }
        }
        int[] result = new int[li.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = li.get(i);
        }
        return result;
    }
}