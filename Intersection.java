// Time Complexity : O(m+n)
// Space Complexity : O(Min(m,n))
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1){
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if(map.containsKey(num)){
                res.add(num);
                int cnt = map.get(num);
                cnt--;
                if(cnt == 0){
                    map.remove(num);
                }
                else {
                    map.put(num,cnt);
                }
            }
        }
        int result[] = new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}