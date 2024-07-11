/*
 * TIme complexity - O(mxn)
 * Space complexity - O(min(m,n))
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m<n){
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i< n; i++){
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)+1); // add the value from 2nd array and update frequency/occurences
        }
        for(int i = 0; i < m; i++){
            if(map.containsKey(nums1[i])){
                result.add(nums1[i]);
                int count = map.get(nums1[i]);
                count--;
                map.put(nums1[i], count);
                map.remove(nums1[i], 0);
            }
        }
        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}