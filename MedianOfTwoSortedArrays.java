// Time Complexity : O((m+n) / 2) , m, n is length of the two arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create two pointers at the start of both the arrays, and while the count of integers parsed is less than (m+n)/2+1, compare the elements at the two pointers and keep the minimum. In this way we can find the middle and previous to middle, ultimately getting the median.

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null && nums2 == null) return -1;
        
        int p1 = 0;
        int p2 = 0;
        
        int total = nums1.length + nums2.length;
        int limit = total/2 + 1;
        
        int count = 0;
        
        int n1 = 0;
        int n2 = 0;
        
        while(count < limit){
            n1 = n2;
            if(p1 < nums1.length && p2 < nums2.length){
                if(nums1[p1] < nums2[p2]){
                    n2 = nums1[p1];
                    p1 = p1 + 1;
                } else {
                    n2 = nums2[p2];
                    p2 = p2 + 1;
                }
            } else if(p1 < nums1.length){
                n2 = nums1[p1];
                p1 = p1 + 1;
            } else if(p2 < nums2.length){
                n2 = nums2[p2];
                p2 = p2 + 1;
            }
            count = count + 1;
        }
        
        if(total % 2 == 0){
            return  Double.valueOf(n1 + n2)/2;
        } else {
            return  Double.valueOf(n2);
        }
            
    }
}
