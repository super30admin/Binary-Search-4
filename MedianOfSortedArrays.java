/*
 * #4. Median of Two Sorted Arrays
 * 
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

1. nums1.length == m
2. nums2.length == n
3. 0 <= m <= 1000
4. 0 <= n <= 1000
5. 1 <= m + n <= 2000
6. -106 <= nums1[i], nums2[i] <= 106

 */


/*
 * Time Complexity: O (Log N) -> Binary Search
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.binarysearch4;

public class MedianOfSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // 1) initialize sizes n1 and n2
        // 2) check which array is smaller
        // 3) Intialize the low and high pointers for Binary Search
        // 4) do binary search on smaller array
        // 5) calculate parititions
        // 6) Get L1, R1, L2, and R2
        // 7) check l1 <= r2 && l2 <= r1 then voila
        // 7.1) check if odd or even and return accordingly
        // 8) If 7 not satisfied, Redo the partitions
        // 9) Return -1 in case if any of the array is null or empty
        
        // # 1. Initialize the length of nums1 and nums2 arrays
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // # 2. Check which array is smaller
        // We assume that nums1 is smaller, but if not,then call the function with flipped arrays -> nums2 as nums1
        // This will ensure that Binary Search will be applied on smaller array
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // # 3. Intialize the low and high pointers for Binary Search
        // low at partition 0
        // And, high at partition n1 -> size of nums1, in case of index it would be n1-1
        int low = 0;
        int high = n1;
        
        // # 4. Apply Binary Search on smaller array
        
        /*
        * Calculate the mid -> partition of smaller array
        * Compute the partition of larger array -> (size of nums1 + size of nums2 + 1) / 2 - partiton at smaller array
        * Get the L1, R1 -> smaller array and L2, R2 -> larger array
        *   Edge case: If partition of smaller array is at 0, then L1 should be -ve infinity -> Integer.MIN_VALUE
        *              Else, L1 should be element at partition -> nums1(partition of smaller array - 1)
        *   Edge case: If partition of smaller array is at n1, then R1 should be +ve infinity -> Integer.MAX_VALUE
        *              Else, R1 should be element at partition in smaller array
        *   Edge case: If partition of larger array is at 0, then L2 should be -ve infinity -> Integer.MIN_VALUE
        *              Else, L2 should be element at partition -> nums2(partition of larger array - 1)
        *   Edge case: If partition of larger array is at n2, then R2 should be +ve infinity -> Integer.MAX_VALUE
        *              Else, R2 should be element at partition in larger array
        * Check if L1 <= R2 and L2 <= R1
        *   If satisfied, calculate median
        *       Check if sum of size of both arrays is even or odd 
        *           If even, return (max(L1,L2) + min(R1,R2) / 2)
        *           If odd, return max(L1, L2)
        *   If not, Re Do the partitions
        *       if(L1 > R2) -> move L1 to the left -> high = mid - 1
        *       if(L2 > R1) -> move R1 to the right -> low = mid + 1
        *           We can move only L1 and R1 in case of wrong partitions because we have mid in smaller array only
        * If any of the given array is null or empty, return -1
        */
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            // # 5. Calculate Partitions
            int partX = mid;
            int partY = (n1+n2+1) / 2 - partX;
            
            // # 6. Get L1, R1, L2, and R2
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            // # 7. check L1 <= R2 && L2 <= R1
                // # 7.1 Check if size of both arrays is odd or even and return median accordingly
            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2) % 2 == 0){
                    return (Math.max(L1,L2) + Math.min(R1,R2)) / 2;
                }else{
                    return Math.max(L1,L2);
                }
            }
            
            // # 8. Redo the partitions, manipulate L1 or R1 as mid is present in smaller array only
            else if(L1 > R2){
                high = mid - 1;
            }
            else if(L2 > R1){
                low = mid + 1;
            }
        }
        
        // # 9. Return -1 in case if any of the array is null or empty
        return -1; 
        
    }

}
