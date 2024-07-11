// Time Complexity : O(m + n) where m is the length of nums1[] and n is the length of nums2[], as we iterate over both the elements
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Store the elements of smaller array in the hashmap with key as the number and value as the number of times that number appears. Then iterate over the other array and check if that number exists, if it does store in the result and reduce the number of occurances by 1 and if the number of occurance is 0 remove from the map.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[] {};
        }

        int m = nums1.length;
        int n = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        if (m < n) {
            intersect(nums2, nums1); //To always ensure nums2 will have less number of elements
        }

        //Store elements in the hashmap which is of smaller length
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        for (int i = 0; i < nums1.length; i++) {

            if (map.containsKey(nums1[i])) {
                answer.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);

                map.remove(nums1[i], 0); // If value is 0 it indicates we have exhausted so remove it from the map
            }
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}