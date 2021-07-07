// Time Complexity :O(n + m) where n is the length of each arrays.
// Space Complexity :O(n) hashmap is to store only one array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1== null || nums2 == null)
            return new int[1];
        
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }else{
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }
        
        for(int i = 0; i< nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                map.put(nums2[i], map.get(nums2[i])-1);
                result.add(nums2[i]);
            }
        }
        
      int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
    
       return r;
    }
}
