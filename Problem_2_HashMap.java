// Time complexity - O(m+n)
// Space complexity - O(m), m is size of larger list

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(nums1.length > nums2.length) intersect(nums2,nums1);
        for(int  i : nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i : nums2){
            if(map.containsKey(i)){
                map.put(i,map.get(i)-1);
                list.add(i);
                map.remove(i,0);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
