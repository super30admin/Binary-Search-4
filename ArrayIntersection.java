//Time Complexity: O(m + n)
//Space Complexity: O(m + min(m,n))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums1) {

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersectionList = new ArrayList<>();
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                intersectionList.add(num);
                freqMap.put(num, freqMap.get(num) - 1); // Decrement frequency
            }
        }
        int[] intersection = new int[intersectionList.size()];
        for (int i = 0; i < intersectionList.size(); i++) {
            intersection[i] = intersectionList.get(i);
        }

        return intersection;
    }
        
}