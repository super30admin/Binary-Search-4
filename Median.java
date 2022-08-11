//Time Complexity: O(logm).
//Space Complexity: O(1).


//This problem can be solved by brute force, but given the fact that the array is sorted, we can use binary search and perform partitions based on that reducing the time complexity. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0 ) return 0.0;
        
        int m = nums1.length;
        int n = nums2.length;
        
        if(n < m){
            return findMedianSortedArrays(nums2, nums1);
        }
       
        int low = 0;
        int high = m;
            
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (m+n)/2 - partX; 
            
            double l1 = Integer.MIN_VALUE;
            double l2 = Integer.MIN_VALUE;
            double r1 = Integer.MAX_VALUE;
            double r2 = Integer.MAX_VALUE;
            
            if(partX != 0)
                l1 = nums1[partX - 1];
            
            if(partY != 0)
                l2 = nums2[partY - 1];
            
            if(partX != m)
                r1 = nums1[partX];
            
            if(partY != n)
                r2 = nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                if((m+n) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
                return Math.min(r1, r2);
            }
            else if(l1 > r2)
                high = partX - 1;
            
            else
                low = partX + 1;
        }
        
        return 0.0;
    }
}