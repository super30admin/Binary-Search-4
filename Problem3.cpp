/* Problem Statement:
https://leetcode.com/problems/median-of-two-sorted-arrays/


4. Median of Two Sorted Arrays
Hard

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5



 *
 * Time Complexity : O((n + m)log (n + m ))  
 * Space complexity : O(m) where m is the size of 2nd array  
 */

/* TODO : IMPROVE THE BRUTE FORCE SOLUTION ... */
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int median = 0;
        int size = 0;
        int valid_idx = 0;
        
        /* BRUTE FORCE SOLUTION */
        /* Copy nums2 to nums1 */
        nums1.insert(nums1.end(), nums2.begin(), nums2.end());
        /* Sort the array */
        sort(nums1.begin(), nums1.end());
        size = nums1.size();
        /* if only 1 element directly return it */
        if (size == 1) {
            return nums1[0];
        }
        /* Even case : idx1 + idx2 / 2 , odd case : idx1 / 2 .. -1 is done to take care of index starting with 0 */
        if ((size % 2) == 0) {
            valid_idx = (size / 2) - 1;
            return (double(nums1[valid_idx] + (nums1[valid_idx + 1])) / 2);
        } else {
            valid_idx = ((size + 1) / 2 ) - 1;
            return (nums1[valid_idx]);
        }
    }
};

/* Execute on leetcode platform */


