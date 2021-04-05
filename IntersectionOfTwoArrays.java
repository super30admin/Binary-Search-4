class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if(n > m){
            return intersect(nums2, nums1);
        }
        //storing smallest array in hashmap with numbers and its count or repetation
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        // when iterating through the second array, if it is present in map add it to result list and reduce the count in map
        int i = 0;
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                nums1[i] = num;
                i++;
                map.put(num, map.getOrDefault(num,0)-1);
            }
        }
        //return the result
        return Arrays.copyOfRange(nums1, 0, i);
    }
}

// Time Complexity: O(n+m)-> asymptotically O(n)
// Space Complexity: O(n)