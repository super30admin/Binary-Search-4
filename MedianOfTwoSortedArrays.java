// TC - O(mlogm + nlogn + mlogn), SC - O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // To do binary search on lower length array for less computations
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        // lengths of 2 arrays
        int m = nums1.length;
        int n = nums2.length;
        // l pointer and m pointer
        int l = 0;
        int r = m;
        // binary search
        while(l <= r){
            // partitionX is mid point in nums1 array and we calculate partitionY such that both combined arrays numbers left side should be equal to right side 
            int partitionX = l+(r-l)/2;
            int partitionY = (m+n+1)/2 - partitionX;
            // finding the 4 pointers
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = partitionX == m ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1]; 
            int minRightY = partitionY == n ? Integer.MAX_VALUE : nums2[partitionY];
            
            // If this conditions is met, we are sure that partitions are in correct position. We can find the median based on combined length of 2 arrays, if it is odd there will be only one mid point and it is 2 we need to find average of 2 mid points
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((m+n) % 2 == 1){
                    return (double)Math.max(maxLeftX, maxLeftY);
                }else{
                    //return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                    double max = Math.max(maxLeftX, maxLeftY);
                    double min = Math.min(minRightX, minRightY);
                    double finRes = (max+min)/2;
                    return finRes;
                }
            }
            // we are moving r pointer else we move right pointer
            else if(maxLeftX > minRightY){
                r = partitionX-1;
            }else{
                l = partitionX+1;
            }
        }
        return -1;
    }
}