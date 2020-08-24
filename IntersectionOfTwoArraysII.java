class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new ArrayList();
        for(int num : nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0) map.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
