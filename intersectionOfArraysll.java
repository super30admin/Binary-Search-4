// TC : O(m+n)
// SC : O(min(m,n))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        
        if(nums1.length < nums2.length) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums2) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        List<Integer> li = new ArrayList<>();
        
        for(int i : nums1) {
            if(map.containsKey(i)) {
                li.add(i);
                map.put(i, map.get(i)-1);
                map.remove(i, 0);
            }
        }
        
        int[] res = new int[li.size()];
        
        for(int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }
        
        return res;
    }
}