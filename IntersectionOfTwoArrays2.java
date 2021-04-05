// TC - O(max(nums1.length, nums2.length)), SC - O(min(nums1.length, nums2.length))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // sanity check
        if(nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        // Initializing an array list
        List<Integer> result = new ArrayList<>();
        // Initializing a hashmap with key as element in array and its count
        Map<Integer, Integer> map = new HashMap<>();
        // Iterating over nums1 and adding in hashmap and its corresponding count
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Iterating over nums2 and if it is present in map, add in list and reduce the count by 1 in map
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result.add(num);
                map.put(num, map.get(num)-1);
            }
        }
        // int array for returning output
        int[] arrRes = new int[result.size()];
        // adding elements into array from list
        for(int i=0; i<result.size(); i++){
            arrRes[i] = result.get(i);
        }
        
        return arrRes;
    }
}