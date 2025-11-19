// Time Complexity : O(m+n) where m and n are lengths of both arrays.
// Space Complexity : O(min(m,n)) for hashmap size
// Did this code successfully run on Leetcode : Yes
// Approach : We store the frequencies of smaller sized array in the hashmap. We loop the other array and check if the element is present
// in the map. If yes, we reduce the frequency and add to the result. In followup part, if the arrays are sorted, we perform Binary Search
// on the larger sized array for each element in the smaller sized array so that time complexity will be m log n.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> res = new ArrayList<>();
        if(n1 > n2){
            return intersect(nums2, nums1); //to use hashmap on smaller sized array
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0) + 1); //store the frequencies
        }

        for(int num : nums2){
            if(map.containsKey(num)){
                res.add(num);//add to result list
                map.put(num, map.get(num) - 1); //reduce the frequency
                map.remove(num, 0);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size();i++){ //convert list to the output array
            result[i] = res.get(i);
        }
        return result;
    }
}