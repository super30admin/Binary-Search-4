// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// Brute Force:
// iterate through elements in two for loops
// check if the elements match if yes, then add into arraylist.

// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
             Map<Integer, Integer> num1Count = new HashMap<>();
        
        for(int n1 : nums1){
            num1Count.put(n1 , num1Count.getOrDefault(n1, 0) + 1 );
        }
        
        List<Integer> results = new ArrayList<>();
        for(int n2 : nums2){
            if(num1Count.containsKey(n2)){
                int count = num1Count.get(n2);
                if(count > 0){
                    results.add(n2);
                    num1Count.put(n2, --count);
                }
            }
        }
        
        int[] intersectVals = new int[results.size()];
        int i = 0;
        for(int r : results){
            intersectVals[i++] = r;
        }
        
        return intersectVals;
    }
}