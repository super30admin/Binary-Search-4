// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity: O(m+n) - O(m) for iterating through the first list and O(n) elements and log(k) for heapify function
//Space Complexity: O(n) since we are using extra datastructures 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2, nums1);
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int i = 0; i < nums2.length; i++){
            int curr = nums2[i];
            if(map.containsKey(curr)){
                result.add(curr);
                map.put(curr, map.get(curr) - 1);
                map.remove(curr, 0);
            }
        }
        
        int[] resultArr = new int[result.size()];
        for(int i = 0; i < resultArr.length; i++){
            resultArr[i] = result.get(i);
        }
        
        return resultArr;
    }
}
