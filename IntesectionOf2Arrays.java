// Time Complexity : O(m+n)
// Space Complexity : O(min(n,m)) // to store hashMap values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Select the smaller array and store its values in HashMap
//Now loop through the second array and check if the value exists in the HashMap
//If it exist put that in num1 and decrease its count in the hashMap
//Now return the range of num1 which is filled with the common values.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int k = 0;
        for(int num: nums1){
            hm.put(num,hm.getOrDefault(num, 0)+1);
        }
        for(int num : nums2){
            int x = hm.getOrDefault(num,0);
            if(x > 0){
                nums1[k++] = num;
                hm.put(num,x-1);
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}