//  TC: O(n1 + n2).
//  SC: O(n1 + min(n1, n2))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> li = new ArrayList<>();

        if(nums1.length>nums2.length){
            intersect(nums2,nums1);
        }

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            int curr=nums2[i];
            if(map.containsKey(curr)){
                li.add(curr);
                map.put(curr,map.get(curr)-1);
                map.remove(curr,0);
            }
        }
        int [] result = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i]=li.get(i);
        }

        return result;
    }
}