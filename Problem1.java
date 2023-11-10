//Time Complexity:(O(min(m,n)))
//Space Complexity:(O(min(m,n)))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) return intersect(nums2,nums1);

        List<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        for(int num:nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num) -1);
                map.remove(num,0);
            }
        }
        int[] result = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
