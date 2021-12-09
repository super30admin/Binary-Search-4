// Time Complexity : O(M+N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer,Integer> map;
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result=new ArrayList<>();
        map=new HashMap<>();
        if(nums2.length>nums1.length) return intersect(nums2,nums1);
        for(int i:nums1){
            if(!map.containsKey(i)){
                map.put(i,0);
            }
            map.put(i,map.get(i)+1);
        }
        
        for(int i: nums2){
            if(map.containsKey(i)){
                result.add(i);
                if(map.get(i)==1){
                    map.remove(i);
                }else{
                    map.put(i,map.get(i)-1);
                }
            }
        }
        
        int[] arr=new int[result.size()];
        int index=0;
        for(int i:result){
            arr[index++]=i;
        }
        
        return arr;
    }
}