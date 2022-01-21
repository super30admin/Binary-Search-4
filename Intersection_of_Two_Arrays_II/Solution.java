// Time Complexity : O(n + m) where n = length of nums1 and m = length of nums2
// Space Complexity :O(length of smallest length array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We iterate over small array and put each int into hashmap along with its frequency in array
 * Then we iterate over 2nd array and check if current element is present in hashmap with freq > 0
 * If yes, we take current num and put it in a list and reduce its count by 1 in hashmap
 * Finally we put all common elements we got in list into an array and return it
*/




class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)return new int[0];
        if(nums1.length > nums2.length)return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length;i++){
           map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        for(int i = 0; i < nums2.length;i++){
            if(map.containsKey(nums2[i])){
                int count = map.get(nums2[i]);
                if(count > 0){
                    temp.add(nums2[i]);
                    map.put(nums2[i], count - 1);
                }
            }
        }
        int[] ans = new int[temp.size()];
        
        for(int i = 0; i < temp.size();i++)ans[i] = temp.get(i);
        
        return ans;
    }
}