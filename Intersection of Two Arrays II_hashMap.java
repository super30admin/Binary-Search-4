https://leetcode.com/submissions/detail/624023292/
// Time:O(m+n)
//Space: O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //
        if(nums1 == null || nums2 == null) {
            return new int[0];
        }
        
        List<Integer> li = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num: nums2) {
            if(map.containsKey(num)) {
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = li.get(i);
        }       
        
        return result;
    }
}	