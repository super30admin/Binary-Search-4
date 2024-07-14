// Time Complexity : O(M+N)
// Space Complexity : O( min(m,n) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return -1.0;
        }
        if (nums1.length == 0 && nums2.length != 0) { // nums1 is empty and nums2 has elements
            int n = nums2.length;
            if (n % 2 == 0) {
                return (nums2[n/2 - 1] + nums2[n/2]) / 2.0;
            } else {
                return nums2[n/2];
            }
        }
        if (nums1.length != 0 && nums2.length == 0) { // nums2 is empty and nums1 has elements
            int m = nums1.length;
            if (m % 2 == 0) {
                return (nums1[m/2 - 1] + nums1[m/2]) / 2.0;
            } else {
                return nums1[m/2];
            }
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        boolean isEven = totalLength % 2 == 0; // even or odd number of total elements

        int l = 0;
        int r = 0;
        int current = 0; // current number
        int prev = 0;
        
        for (int i = 0; i <= totalLength / 2; i++) { // iterating m+n /2 times, half of total length
            prev = current;
            if (l < m && (r >= n || nums1[l] < nums2[r])) { // nums1 has smaller element, also check if r pointer is less than total elements in nums2
                current = nums1[l];
                l++;
            } else {
                current = nums2[r];
                r++;
            }
        }

        if (isEven) {
            return (prev + current) / 2.0; // taking prev for this reason
        } else {
            return current;
        }
    }
}

// Solution 2 - Binary search approach
// Time Complexity : O(log M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return -1.0;
        }
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2, nums1); // we want nums1 to be smaller
        }
        int low = 0;
        int high = m ;
        while(low<=high){
            int partX = low + (high-low)/2;
            int partY = (m+n)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1]; 
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            if(l1 <=r2 && l2<=r1){
                if( (m+n) %2 ==0 ){
                    return ( Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }
                return Math.min(r1,r2);
            }else if(l1 > r2){
                high = partX - 1;
            }else if(l2 > r1){
                low = partX + 1;
            }
        }
        return 453.8;
    }
}