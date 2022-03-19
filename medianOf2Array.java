/**

TC - O(N + M) where N is the length og first array and M is the length of second array.
SC - O(K) where K is M or N


4 5 9

4

4 4 8 9 9

**/
class Solution {
    //, 5 => 1
    
    // 9, 4
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        List<Integer> results = new ArrayList<>();
        
        Map<Integer, Integer> valueToFrequency = new HashMap<>();
        
        for (int first : nums1)
        {
            valueToFrequency.put(first, valueToFrequency.getOrDefault(first, 0) + 1);
        }
        
        for (int second : nums2)
        {
            if (valueToFrequency.containsKey(second))
            {
                results.add(second);
                valueToFrequency.put(second, valueToFrequency.get(second) - 1);
                
                if (valueToFrequency.get(second) == 0)
                {
                    valueToFrequency.remove(second);
                }
            }
        }
        
        valueToFrequency.clear();
        
        int[] output = results.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        
        return output;
    }
}
