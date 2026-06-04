// Time Complexity : O(n1 + n2) because we traverse both arrays once
// Space Complexity : O(min(n1, n2)) for the frequency map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We store the frequency of elements from the larger array in a HashMap.
// While traversing the second array, we add common elements to the result and decrease their remaining frequency.
// Finally, we convert the result list into the required integer array.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // build frequency map on larger array
        if(n2 > n1) return intersect(nums2, nums1);

        HashMap<Integer, Integer> fMap = new HashMap<>();

        for(int num : nums1) {
            fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(int num : nums2) {
            if(fMap.containsKey(num)) {
                result.add(num);

                fMap.put(num, fMap.get(num) - 1);
                fMap.remove(num, 0);
            }
        }

        int[] re = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }

        return re;
    }
}