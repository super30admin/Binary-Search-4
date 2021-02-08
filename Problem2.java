// https://leetcode.com/problems/median-of-two-sorted-arrays/
// Time complexity : O(N)
// Space complexity : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int mid = (n1+n2)/2;
        int curr = 0;
        int prev = 0;
        int i1 = 0;
        int i2 = 0;
        while(mid-- >= 0){
            prev = curr;
            if(i1 == n1)
                curr = nums2[i2++];
            else if(i2 == n2)
                curr = nums1[i1++];
            else if(nums1[i1] < nums2[i2])
                curr = nums1[i1++];
            else
                curr = nums2[i2++];
        }
        
        if((n1+n2)%2 == 0)
            return (prev+curr)/2.0;
        return curr;
        
        
    }
}