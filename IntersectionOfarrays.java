// Time complexity - O(n)
// Space complexity - O(n)
//solved on leetcode- yes
// faced any issues - no
// Maintaining a hashMap with have the frequencies of an array and then iterating to each element of other array and checking if it's there in hashmap or not and then update the result
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int k = 0;

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result[k++] = num;
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }
}
