// Time Complexity : O(log length of longest array)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We will partition the longest array and figure out how many elements from 1st and 2nd array will go in left side of median
 * We find find 1st array partition with binary search and use mid point as partition. for 2nd array we use formula (nums1.length + nums2.length)/2 - mid
 * Then we check if partition is correct using l1 r1 and l2 r2 where (l1 <= r2) and (r1 <= l2)
 * If above conditions get match then depending upon is sum of lengths of array is even is odd we return median
 * Else we continue our search to find correct partition 
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)return 0.0;
        int len = nums1.length + nums2.length;
        int l = 0;
        int r = nums1.length;
        
        
        if(nums1.length > nums2.length)return findMedianSortedArrays(nums2, nums1);
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            int arr2_index = (len / 2) - (mid);
            
            
            double l1 = Integer.MIN_VALUE;
            if(mid > 0){
                l1 = nums1[mid-1];
            }
            double l2 = Integer.MAX_VALUE;
            if(nums1.length - mid > 0){
                l2 = nums1[mid];
            }
            
            double r1 = Integer.MIN_VALUE;
            if(arr2_index > 0){
                r1 = nums2[arr2_index-1];
            }
            double r2 = Integer.MAX_VALUE;
            if(nums2.length - arr2_index > 0){
                r2 = nums2[arr2_index];
            }
            
            if(l1 <= r2 && r1 <= l2){
               if(len % 2 == 0){
                    return (Math.max(l1, r1) + Math.min(l2,r2)) / 2;
                }else{
                    return Math.min(l2, r2);
                }
            }else{
                if(l1 > r1){
                    r = mid - 1;
                }else if(r1 > l2){
                    l = mid + 1;
                }
            }
        }
        
        return -1;
    }
}