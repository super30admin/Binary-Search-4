// Time Complexity : O(m+n) where m = size of bigger array and n = size of smaller array (if arrays are already sorted)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // intialize two pointers - one on each sorted array
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < nums1.length && p2 < nums2.length){
            // if elements are equal
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]);
                p1++;
                p2++;
            }
            // if element at nums1 is less than element at nums2; increment the p1 pointer
            else if(nums1[p1] < nums2[p2]){
                p1++;
            } 
            // if element at nums2 is less than element at nums1; increment the p2 pointer
            else{
                p2++;
            }
        }
        
        // copy list into result array
        int [] result = new int [li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}