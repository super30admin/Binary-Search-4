/* 
Time Complexity: O(log(min(m, n))) 
   - We do binary search only on the smaller array.

Space Complexity: O(1)

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// 1. Ensure nums1 is the smaller array to keep binary search efficient.
// 2. Partition nums1 at index partX, and partition nums2 accordingly so that the total left side has (m+n)/2 elements.
// 3. Define L1 = max of left side of nums1, R1 = min of right side of nums1;
//    L2 and R2 similarly for nums2.
// 4. If L1 <= R2 and L2 <= R1, we found a correct partition:
//      - If total length is even → median = (max(L1, L2) + min(R1, R2)) / 2
//      - If total length is odd  → median = min(R1, R2)   // from the right partition
// 5. If L2 > R1, move partition right (low = partX + 1). Else move left (high = partX - 1).
// 6. Continue binary search until a valid partition is found.

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2) % 2 == 0){ // even length
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2;
                }else{
                    return Math.min(R1, R2); // odd length
                }
            }else if(L2 > R1){
                low = partX + 1;
            }else{
                high = partX - 1;
            }
        }
        return -1;
    }
}
