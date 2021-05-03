
// Time Complexity : O(N+M)
// Space Complexity : O(min(N,M))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums1)
            map.put(num,map.getOrDefault(num,0)+1);
        for(int num: nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num,map.get(num)-1);
                map.remove(num,0);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++)
            res[i] = result.get(i);
        return res;
    }
}
