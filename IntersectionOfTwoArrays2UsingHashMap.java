// TC: O(m + n)
// SC: O(min(m, n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m, n;
        m = nums1.length;
        n = nums2.length;
        if(m > n) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num)) {
                temp.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] res = new int[temp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}
