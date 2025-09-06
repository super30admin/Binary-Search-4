class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int z:nums1)
            map.put(z,map.getOrDefault(z,0)+1);
        for(int z:nums2){
            if(map.containsKey(z)){
                res.add(z);
                map.put(z,map.get(z)-1);
                map.remove(z,0);
            }
        }
        int ans[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}