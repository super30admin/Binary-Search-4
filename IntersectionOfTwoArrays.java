// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int n: nums2) {
            if(map.containsKey(n)) {
                result.add(n);
                map.put(n, map.get(n)-1);
                map.remove(n, 0);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}