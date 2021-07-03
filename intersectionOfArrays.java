//time complexity O(m + n) where m and n is the length of respective arrays
//space complexity O(Math.min(m,n)) i.e. in worst case all the elements match in the smaller array and that will be put in HashMap.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||
           nums2 == null || nums2.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
