// Time Complexity : O(n1 + n2)
// Space Complexity : O(n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num:nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        
        int[] result = new int[list.size()]; 
        for(int i = 0;i < result.length; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}