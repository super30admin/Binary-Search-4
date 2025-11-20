// 4. Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

/**
 * Approach: We want to find median of sorted arrays. Median always lies in the center part of the array.
 * If total elements are even for eg. 10 and if we part them equally, we would have 5 elements on left and 5 elements on right
 * So, the median would be (5th ele + 6th ele / 2)
 * 
 * If total elements are odd eg. 9, and if we try to part them equally, there would 4 elements on one side and 5 elements on other side.
 * In this case, we would return the first extra element from other side.
 * 
 * Since, the arrays are sorted we can try to create a partition between between left and right side, where left side elements
 * are smaller than right side elements.
 * 
 * But we need to balance the number of elements on left and right side i.e if total elements are 10, 
 * we must have 5 on left and 5 on right
 * 
 * For left side, we can try combination of elements from both arrays. 
 * i.e we can take 2 from 1st, 3 from 2nd
 * or 5 from 1st, 0 from 2nd etc.
 * 
 * There would only be 1 perfect partition where left elements would be smaller than right elements
 * 
 * We can apply Binary Search on one array (smaller) for find perfect partition
 * Maintain 4 variables 
 * left1 = max element of 1st array on left side
 * left2 = max element of second array on left side
 * 
 * right1 = min element of first array on right side
 * right2 = min element of second array on right side
 * 
 * l1, r1 => represents first array
 * l2, r2 => repesents second array
 * 
 * Cross checking will tell us whether left side elements are less than right side elements
 * 
 * l1 < r1 && l2 < r2 if this condition is satisfied, we found our perfect partition
 * 
 * then we can calculate median using l1,l2,r1,r2
 * 
 */


/**
 * Time Complexity: O(min(log(m,n))) since we apply binary search on smaller array
 * Time Complexity: O(1)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = n + m;

        int left = total / 2;

        int start = 0;

        //since we do binary search on partition and not index, we need one extra partition hence nums1.length and not nums1.length - 1;
        int end = nums1.length; 

        while(start <= end){

            // calculate partition
            int mid = start + (end - start) / 2;

            int rem = left - mid;

            // on left side, if we dont take any element from 1st array, L1 on left side would be -Infinity
            int L1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];

            // on left side, if all elements are taken from 1st array, we dont have anything to take from 2nd array hence +infinity
            int L2 = rem == 0 ? Integer.MIN_VALUE : nums2[rem - 1];

            // on right side, remaining elements from 1st array, if no remaining elements +infinity
            int R1 = mid == n ? Integer.MAX_VALUE : nums1[mid];

            // on right side, remaining elements from 2nd array, if no remaining elements +infinity
            int R2 = rem == m ?  Integer.MAX_VALUE : nums2[rem];

            // check if left side elements are smaller then right side (just check last element as sorted arrays)
            // if not adjust the partition by discarding half side 
            if(L1 > R2){
                end = mid - 1;
            }else if(L2 > R1){
                start = mid + 1;
            }else{
                // correct partition

                if(total % 2 == 0){ // even
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }else{ // odd
                    return Math.min(R1,R2);
                }
            }

        }

        return 0.0;
    }
}

