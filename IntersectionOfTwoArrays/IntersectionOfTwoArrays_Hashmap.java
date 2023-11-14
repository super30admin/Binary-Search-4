/* Time Complexity : O(m + n)  
*   m - len of array nums1
*   n - len of array nums2 */
/* Space Complexity : O(min(m,n)) + O(k) 
*   k - len of result stored in the list - li */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Hashmap solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // To create hashmap of the smaller array
        if(m > n) return intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        //freq of ele in smaller array
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //iterate over the larger array
        //add to the list of num is present in hashmap and decrement it's count by 1
        //If the count becomes zero remove it's entry from hashmap
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        //Iterate over list and add to result
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i ++){
            result[i] = li.get(i);
        }
        return result;
    }
}