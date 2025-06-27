//Time Complexity : O(log (m+n))
// Space Complexity : O(1)
// m = nums1 array length n = nums2 array length

/* Approach : The function finds the median of two sorted arrays by using a binary search on the smaller array to partition both arrays 
into two halves. The goal is to ensure that all elements in the left halves are less than or equal to all elements in the right halves. 
By adjusting the partition positions based on comparisons, the function efficiently narrows down the correct partition. 
Once the correct partition is found, the median is calculated based on the total number of elements (odd or even).
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;
        
        // Ensure nums1 is the smaller array
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n1;
        
        while(low <= high){
            // Partition nums1
            int partx = low + (high - low) / 2;
            // Partition nums2
            int party = (n1 + n2) / 2 - partx;
            
            // Edge cases for partitioning
            double x1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
            double y1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            double x2 = party == 0 ? Integer.MIN_VALUE : nums2[party - 1];
            double y2 = party == n2 ? Integer.MAX_VALUE : nums2[party];

            // Check if we have a correct partition
            if(x1 <= y2 && x2 <= y1){
                // If the total number of elements is even
                if((n1 + n2) % 2 == 0){
                    return (Math.min(y1, y2) + Math.max(x1, x2)) / 2;
                }
                // If the total number of elements is odd
                else{
                    return Math.min(y1, y2);
                }
            }
            // Adjust the partition
            else if(x1 > y2){
                high = partx - 1;                
            } else {
                low = partx + 1;                
            }
        }        
        return 3.00; // This line should never be reached
    }
}
