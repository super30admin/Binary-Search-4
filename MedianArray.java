/*
worked on LC : YES
Time complexity : O(logn)
spacce complexity : O(1)
*/

class Solution {
    
    // 1 7 8 10 11
    // 2 3 4 5 6 12 13
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        
        int n = nums1.length;
        int m  = nums2.length;
        
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n;
        
        
        while(low <= high) {
            
            int partX = low + (high - low) /2;
            
            int partY = (m+n)/2 - partX;
            
//             boundy elements and make partitions
            //             there are no element in first array left 
            double l1 =  (partX == 0 ) ? Integer.MIN_VALUE : nums1[partX-1];
            //             there are no element in first array right 
            double r1 =  (partX == n ) ? Integer.MAX_VALUE : nums1[partX];
            //             there are no element in second array left
            double l2 =  (partY == 0 ) ? Integer.MIN_VALUE : nums2[partY-1];
            //             there are no element in second array right
            double r2 =  (partY == m ) ? Integer.MAX_VALUE : nums2[partY];
            
            
            if(l1 <= r2 && l2 <= r1) {
                // found the partition
                // if even 
                if((m + n)%2  == 0 ) {
                    return (Math.max(l1,l2) + Math.min(r1,r2) )/2;
                }else{
                    // if odd
                    return Math.min(r1, r2);
                }
            }else if ( l2 > r1) {
                //  increase left partition                     
                low = partX+1;
            }else{
                high = partX-1;
            }
            
            
        }
        
        return Double.MIN_VALUE;
        
    }
}
