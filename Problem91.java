//Time Complexity: O(m + n)
//Space Complexity: O(min(m, n)) for the frequency map.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int num: nums2) {
            if(map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num, 0);
            }
        }

        int[] li = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            li[i] = result.get(i);
        }

        return li;
    }
}