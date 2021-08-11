class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 || nums1 == null) {
            return nums1;
        }
        if(nums2.length == 0 || nums2 == null) {
            return nums2;
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) {
            intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < n2; i++) {
            if(map.containsKey(nums2[i])) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                
                if(map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
            }
            
        }
        
        int[] output = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}

//Time : O(n + m)
//Space : O(min(n,m))