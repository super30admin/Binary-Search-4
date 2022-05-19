class intersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[] {};
        }
        
        if(nums2.length < nums1.length) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num : nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

//time complexity O(m + n) where m is length of nums1 & n is length of nums2
//space complexity O(n) 