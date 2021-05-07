//Time Complexity:O(n+m) n is length of nums1 and m is length of nums2
//Space Complexity:O(n or m)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num: nums2){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                res.add(nums1[i]);
                if(map.get(nums1[i])>1) map.put(nums1[i],map.get(nums1[i])-1);
                else map.remove(nums1[i]);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}