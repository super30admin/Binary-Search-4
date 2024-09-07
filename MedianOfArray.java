// Time Complexity : O(log(min(m,n)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Binary search the small array to find the correct partition index
// Partition is correct when elements in left partition < right partition

public class MedianOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1+n2;

        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0; int high = n1;

        while (low<=high) {
            int partX = low + (high-low)/2; // number of elements from nums1 left side of partition
            int partY = (total)/2 - partX; // number of elements from nums2 left side of partition

            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1]; // left part last element from nums1 
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX]; // right part first element from nums1

            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];  // left part last element from nums2 
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY]; // right part first element from nums2

            if(L1<=R2 && L2<=R1){
                if(total%2 != 0)
                    return Math.min(R1,R2); // for odd number - one value median
                else
                    return (Math.min(R1,R2) + Math.max(L1, L2))/2.0; //for even - average of middle elements

            } else if(L1>R2)
                high = partX -1;
            else
                low = partX +1;
        }

        return -1;
    }
}
