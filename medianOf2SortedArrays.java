// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

// Time Complexity : O(log(m)) i.e., smaller array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take the smaller array and find mid taking low as 0 and high as "length". Then find mid and get the elements L1, R1, L2, R2
 * accordingly. Check if L1<=R2 && L2<=R1 if yes then for even number of elements return sum of max of L1, L2 and min of R1,R2 divided
 * by 2 and for odd case returm min of R1, R2. If not check if L1>R2, if yes then move high to mid -1 else move low to mid +1;
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            int L1 = mid == 0? Integer.MIN_VALUE: nums1[mid-1];
            int R1 = mid == m? Integer.MAX_VALUE:nums1[mid];
            int Y = (m+n)/2 - mid;
            int L2 = Y == 0? Integer.MIN_VALUE:nums2[Y-1];
            int R2 = Y == n? Integer.MAX_VALUE:nums2[Y];
            if(L1<=R2 && L2<=R1){
                if((m+n)%2 == 0){
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2.0;
                }
                else{
                    return Math.min(R1,R2);
                }
            }
            else if(L1>R2){
                high = mid -1;
            }
            else{
                low = mid+1;
            }

        }
        return -1;
    }
}