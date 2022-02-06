// Time Complexity : O(m+n) where m = size of bigger array and n = size of smaller array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        List<Integer> li = new ArrayList<>();
        
        // create HashMap for smaller array
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums1){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        
        // traverse the bigger array and check for it in the HashMap
        for(int i : nums2){
            int element = i;
            if(map.containsKey(element)){
                li.add(element);
                map.put(element, map.get(element) - 1);
                map.remove(element,0);
            }
        }
        
        // copy list into result array
        int [] result = new int [li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}