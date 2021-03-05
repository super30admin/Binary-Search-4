// Time Complexity : O(mlogm + nlogn)
// Space Complexity : O(m) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        
        if(m>n) return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int[] ans = new int[m];
        
        int j=0;
        int k=0;
        for(int i=0;i<m&&j<n;) {
            
            if(nums1[i]==nums2[j]) {
                ans[k++] = nums1[i];
                i++;
                j++;
            } 
            else if(nums1[i]>nums2[j]) {
                j++;
            } else {
                i++;
            }
            
        }
        
        return Arrays.copyOfRange(ans, 0, k);
    }
}
