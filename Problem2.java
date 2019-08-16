class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        if(nums1.length>nums2.length){
            for(int i: nums1){
                if(!map.containsKey(i)) map.put(i,1);
                else    map.put(i,map.get(i)+1);
            }
            for(int i:nums2){
                if(map.containsKey(i) && map.get(i)>0){
                    output.add(i);
                    map.put(i,map.get(i)-1);
                }
            }
        }
        else{
            for(int i: nums2){
                if(!map.containsKey(i)) map.put(i,1);
                else    map.put(i,map.get(i)+1);
            }
            for(int i:nums1){
                if(map.containsKey(i) && map.get(i)>0){
                    output.add(i);
                    map.put(i,map.get(i)-1);
                }
            }
        }
        int[] result = new int[output.size()];
        for(int i=0;i<result.length;i++){
            result[i] = output.get(i);
        }
        return result;
    }
}
