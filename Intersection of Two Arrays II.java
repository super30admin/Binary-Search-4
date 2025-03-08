class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         // Ensure nums1 is the smaller array for optimized space complexity
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        // Count elements in the smaller array
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        // Iterate through the larger array and collect intersections
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                result.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }
        
        // Convert result list to array
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        
        return intersection;
        
    }
}

/*
Overall Time Complexity (TC):
- Counting elements in the smaller array: O(n)
- Iterating through the larger array: O(m)
- Converting list to array: O(min(n, m))
- Total TC: O(n + m)

Overall Space Complexity (SC):
- Frequency map: O(n) where n is the size of the smaller array
- Result list: O(min(n, m)) for storing intersection elements
- Output array: O(min(n, m))
- Total SC: O(n + min(n, m)), which simplifies to O(n)
*/