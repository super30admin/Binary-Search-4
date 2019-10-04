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



 * Solution 1 : 
 * Time Complexity : O((n + m)log (n + m ))  
 * Space complexity : O(m) where m is the size of 2nd array  

 * Solution 2: Use two pointers approach to create a new array by merging 2 sorted arrays 
 * Time Complexity: O(m+n)
 * Space complexity : O(m+n) 
 */

/* TODO : IMPROVE THE O(m+n) to O(log(m+n)) solution  ... */

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

    double findMedianSortedArray_version2(vector<int>& nums1, vector<int>& nums2) {
        int median = 0;
        int size = 0;
        int valid_idx = 0;
        int idx1 = 0, idx2 = 0;
        vector<int> result;
        
        /* Two pointer solution : to merge 2 sorted arrays */
        for (idx1 =0, idx2 = 0; idx1 < nums1.size() && idx2 < nums2.size();) {

            if (nums1[idx1] > nums2[idx2]) {
                result.push_back(nums2[idx2++]);
            } else if (nums1[idx1] == nums2[idx2]) {
                result.push_back(nums1[idx1++]);
                result.push_back(nums2[idx2++]);
            } else {
                result.push_back(nums1[idx1++]);                
            }
        }
        /* Take care of the rest of the elements if its still present */
        while (idx1 < nums1.size()) {
            result.push_back(nums1[idx1++]);
        }
        while (idx2 < nums2.size()) {
            result.push_back(nums2[idx2++]);
        }
        
        size = result.size();
        
        /* if only 1 element directly return it */
        if (size == 1) {
            return result[0];
        }
        /* Even case : idx1 + idx2 / 2 , odd case : idx1 / 2 .. -1 is done to take care of index starting with 0 */
        if ((size % 2) == 0) {
            valid_idx = (size / 2) - 1;
            return (double(result[valid_idx] + (result[valid_idx + 1])) / 2);
        } else {
            valid_idx = ((size + 1) / 2 ) - 1;
            return (result[valid_idx]);
        }
    }
};


/* Execute on leetcode platform */


