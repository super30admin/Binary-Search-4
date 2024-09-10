// Time Complexity: O(n + m)
// Space Complexity: O(min(n, m))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // HashMap to store the frequency of elements in nums1
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        
        // Fill the hashmap with elements from nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Check elements from nums2 against the map
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);  // Add the element to the result list
                map.put(num, map.get(num) - 1);  // Decrease the count in the map
            }
        }
        
        // Convert the result list to an array
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}
