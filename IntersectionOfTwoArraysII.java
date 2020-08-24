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


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        int i = 0; int j = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        
        int[] res = new int[list.size()];
        for(int k = 0; k < list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }
}
