// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//TimeComplexity - O(log(n)) since we are reducing the operations required by equally partitioning these arrays
//SpaceComplexity - O(1) since we are not using any extra space
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int left = 0 ; int right = n1;
        
        while(left <= right){
            int partX = left + (right - left)/2;
            int partY = (n1 + n2)/ 2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <= R2 &&  L2 <= R1){ // Selecting correct partition
                //finding median
                //Even case - Combined array is even number
                if((n1+n2)%2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2;
                }else{ // Odd case - Combined array is odd number
                    return Math.min(R1, R2);
                }
            }else if(L2 > R1){
                left = partX + 1;
            }else{
                right = partX - 1;
            }
        }
        
        return 1.00;        
    }
}