// Time Complexity : O(log n) where n is the length of the shorter array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with this approach
/* Your code here along with comments explaining your approach: Create partitions in the both the arrays. Divide the array into equal parts such that
both the arrays have same number of partitions as per array length as odd or even. Use the formula to get the partition from the shorter array, use
the formula length of array 1 + length of array 2 + 1 (for odd length total) divide by 2 and partition X to get the partition index of longer array.
Once partitions are found, assign l1, l2 and r1, r2. Assign the nums 1 partition index l1 and the next element to l1 as r1. Similarly assign l2 and r2.
If l1 < r2 and l2 < r1, it means all elements in the left are lesser than elements on the right => array is sorted, where array is the consideration
of nums 1 and nums2 both. If the total length is odd, return max of l1 and l2 else if the length is even, return the median using the formula. 
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int start = 0, end = nums1.length;
        while(start <= end){
        int partX = start + (end-start)/2;                                                                  // Partition X formula
        int partY = ((nums1.length + nums2.length + 1)/2) - partX;                                          // Partition Y formula using partition X
        double l1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX-1];                                  // Assign l1 to Partition X element
        double l2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY-1];                                  // Assign l2 to Partition Y element
        double r1 = (partX == nums1.length) ? Integer.MAX_VALUE : nums1[partX];                         // Assign r1 to the next element of l1
        double r2 = (partY == nums2.length) ? Integer.MAX_VALUE : nums2[partY];                         // Assign r2 to the next element of l2
        if(l1 <= r2 && l2 <= r1){                                                                       // if the complete array is sorted
            if(((nums1.length + nums2.length) % 2) == 0) {                                              // if the length is even
                return (Math.max(l1,l2) + Math.min(r1, r2))/2;                                          // return the median
            } else {
                return Math.max(l1,l2);                                                                 // if the length is odd, return the median
            }
        } else 
        if(l1 > r2)                                                                                     // if violation occurs
        {
            end = partX-1;                                                                              // Reduce to left in partition X
        } else {
            start = partX+1;                                                                            // Adjust ot the right in partition X
        }
        }
        return -1;                                                                                  // No median found, impossible
    }
}