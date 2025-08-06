// Time Complexity : O(n+m)
// Space Complexity : O(min(n, m))
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Approach : I added every element of the smaller array to a Hashmap with the frequency count, then I iterated through the larger array and checked if the element exists in the Hashmap. If it does, I added it to the result list and decreased its frequency count in the Hashmap. This ensures that we only add elements that are present in both arrays and respects their counts.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) map.put(n, map.getOrDefault(n, 0)+1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                list.add(n);
                map.put(n, map.get(n)-1);
            }
        }
        int [] ans = new int [list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }       
}