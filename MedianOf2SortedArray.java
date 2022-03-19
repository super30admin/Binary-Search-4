// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take two pointer run  these pointers over the two array
// Determine when the median will be reached.
// Write logic for odd and even case of median and check corner cases.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = -1;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = (l1 + l2)/2;
        int p1 = 0, p2 = 0;
        if(l1 == 0){
            if(l2%2 == 1){
                return (double)nums2[l2/2];
            }
            else{
                return (nums2[l2/2-1]+nums2[l2/2])/2.0;
            }
        }
        if(l2 == 0){
            if(l1%2 == 1){
                return (double)nums1[l1/2];
            }
            else{
                return (nums1[l1/2 -1]+nums1[l1/2])/2.0;
            }
        }
        if((l1+l2)%2 == 0)
            l--;
        while(p1+p2 < l){
            if(p1 >= l1){
                p2++;
                continue;
            }
            if(p2 >= l2){
                p1++;
                continue;
            }
            int n1 = nums1[p1];
            int n2 = nums2[p2];
            if(n1 <= n2){
                p1++;
            }
            else{
                p2++;
            }
        }
        if((l1+l2)%2 == 1){
            if(p1 >= l1){
                ans = nums2[p2];
            }
            else if(p2 >= l2){
                ans = nums1[p1];
            }
            else{
            ans = Math.min(nums1[p1], nums2[p2]);
            }
        }
        else{
            int first = 0;
            int second = 0;
            if(p1 >= l1){
                first = nums2[p2];
                p2++;
            }
            else if(p2 >= l2){
                first = nums1[p1];
                p1++;
            }
            else{
                if(nums1[p1] <= nums2[p2]){
                    first = nums1[p1];
                    p1++;
                }
                else{
                    first = nums2[p2];
                    p2++;
                }
            }
            if(p1 >= l1){
                second = nums2[p2];
            }
            else if(p2 >= l2){
                second = nums1[p1];
            }
            else{
            second = Math.min(nums1[p1], nums2[p2]);
            }
            ans = (first + second) / 2.0;
        }
        return ans;
    }
}