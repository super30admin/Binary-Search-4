// Time Complexity : O(n1+n2)) iterate oevr two arrays
// Space Complexity : O(n1) to store the nums1 elements in the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        List<Integer> output = new ArrayList();
        
        for(int num: nums2){
            if(map.getOrDefault(num,0) >= 1){
                output.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int op[] = new int[output.size()];
        int i = 0;
        
        for(int num: output){
            op[i++] = num;
        }
        return op;
    }
}
