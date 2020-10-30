// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes, 2ms
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

//store array1 in map and search array2 elements in map and found key are addded in a list to be converted into an array

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> list = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
            
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
            
        }
        
        for(int i = 0; i < nums2.length; i++){
            
            if(map.containsKey(nums2[i])){
                
                int count = map.get(nums2[i]);
                
                if(count > 0){
                    list.add(nums2[i]);
                    map.put(nums2[i], --count);
                }
                
            }
            
        }
        
        int[] ans = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            
            ans[i]= list.get(i);
        }
        
        return ans;
        
    }
}