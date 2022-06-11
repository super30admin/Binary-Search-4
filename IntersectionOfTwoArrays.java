// Time Complexity : O(m+n) m =nums1 n =nums2
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            intersect(nums2, nums1);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums1){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i] = result.get(i);
        }
        
        return arr;
    }
}