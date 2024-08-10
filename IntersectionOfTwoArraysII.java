// TC: O(nums1 + num2)
// SC: O(sizeof(nums1))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    resultList.add(nums2[i]);
                    map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
                }
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }
}