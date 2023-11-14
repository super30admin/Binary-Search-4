/* Time Complexity : O(m + n)  - provided we consider both arrays to be sorted
*   m - len of array nums1
*   n - len of array nums2 */
/* Space Complexity : O(k) 
*   k - len of result stored in the list - li */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Two pointer solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // To create hashmap of the smaller array
        if(m > n) return intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); //m log m
        Arrays.sort(nums2); //n log n
        int p1 = 0;
        int p2 = 0;
        while(p1 < m && p2 < n){
            if(nums1[p1] == nums2[p2]){
                //Values are equal add to list and increment both pointers
                li.add(nums1[p1]);
                p1++;
                p2++;
            }
            //Increment the pointer with less value
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
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