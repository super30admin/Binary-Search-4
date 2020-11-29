// Time Complexity :  O(M + N) - shorter string 
// Space Complexity : O(M) - longer string
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) 
            return intersect(nums2, nums1);
        Map<Integer,Integer> map = new HashMap<>();  //O(N)
        for(int i = 0; i < nums2.length; i++){
            if(!map.containsKey(nums2[i]))
                map.put(nums2[i],1);
            else
                map.put(nums2[i], map.get(nums2[i]) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0){
                res.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }
        }
        int[] result = new int[res.size()];
        
        for(int i = 0; i< res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
//O(M + N)