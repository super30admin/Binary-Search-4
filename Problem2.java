// Median of two sorted arrays
// Time - Log(nums1) or log(nums2) depends on whichever is small
// Space - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if (n1 > n2){
           return findMedianSortedArrays(nums2, nums1);
        }
        
        int start = 0;
        int end = n1;
        
        while(start <= end){
            
            int partX = start + (end - start)/2;
            int partY = (n1 + n2)/2 - partX;
            
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2)%2 == 0){
                    
                    return (Math.min(R1,R2) + Math.max(L1,L2))/2;
                }else{
                    return Math.min(R1, R2);
                }
            }else if(L2 > R1){
                start = partX + 1;
            }else{
                end = partX - 1;
            }
        }
        
        return -123;
    }
}