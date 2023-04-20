/*
    L = min(size of nums1, size of nums2)
    Time Complexity - O(Log(L))
    Space complexity - O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int len1 = nums1.length, len2 = nums2.length;  
        int totalLen = len1 + len2;
        int low = 0, high = len1;
    
        // sum of xpartition and ypartition should always be equal to half of sum of 2 array lengths combined.
        // xpartition + ypartition = (len1 + len2 + 1) / 2;
        
        while(low <= high) {   
            int xPartition = (low + high) / 2;
            int yPartition = (totalLen + 1) / 2 - xPartition;

            int maxLeftX = (xPartition == 0) ? Integer.MIN_VALUE : nums1[xPartition - 1];
            int maxLeftY = (yPartition == 0) ? Integer.MIN_VALUE : nums2[yPartition - 1];
            
            int minRightX = (xPartition == len1) ? Integer.MAX_VALUE : nums1[xPartition];
            int minRightY = (yPartition == len2) ? Integer.MAX_VALUE : nums2[yPartition];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((totalLen & 1) == 0)
                    return ((double)Math.max(maxLeftX, maxLeftY) +
                                Math.min(minRightX, minRightY))/2;
                else
                    return (double)(Math.max(maxLeftX, maxLeftY));
            }
            else if(maxLeftX >= minRightY) {
                high = xPartition - 1;
            }
            else {
                low = xPartition + 1;
            }
            
        }
        return Integer.MIN_VALUE;
    }
}
