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

 * Solution 3: Use binary search to move around pointers 
 * Time Complexity: O(log(m+n))
 * Space complexity : O(1)  
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

    double findMedianSortedArrays_ver3(vector<int>& nums1, vector<int>& nums2) {
        double median = 0;
        bool is_even = false;
        int mid_for_both_arr = 0;
        int start, end, mid;
        int len1 = nums1.size();
        int len2 = nums2.size();
        int partition_nums1, partition_nums2;
        int left_min, right_min, left_max, right_max;
        
        if (len1 > len2) {
            /* If first array is larger than 2nd array, either swap it or call the function again with
             * swapped parameters. */
            return findMedianSortedArrays(nums2,nums1);
            /* Method 2 */
            //nums1.swap(nums2);
            //swap(len1,len2);
        }
        
        /* Find total count is even or odd */
        if ((len1 + len2) % 2 == 0) {
            is_even = true;
        }
        
        /* We want to partition the final merged array (we are not actually merging it, but going to find the merge
         points using binary search) size. for eg 
          arr2: [1,3]
          arr1: [2,4]
          final_merge should be at 2 + 2 + 1 / 2 = 2 ie 1,2  (median is here )  , 3 ,4 
         */
        mid_for_both_arr = (len1 + len2 + 1) / 2;
        
        /* initialize start and end for binary search */
        start = 0;
        end = nums1.size();
        
        while (start <= end) {
            
            mid = (start + end) / 2;
            /* mid is the point for first array and based on that point, 2nd array's mid point will be decided
             1st array : 1  3  | 8  9  5
             2nd array : 7 11 18 19 | 21  25

             mid_arr_size = 5 + 6 + 1 / 2 = 6
             for start = 0 end = 5, mid is
             mid : 0 + 5 / 2 = 2
              first iteration indexes
             leftmin_idx = mid - 1 ie 1st index,
             rightmin_idx = mid ie 2nd index,
             rightmin_idx = 6 - mid = 4 .. ie 3rd index of 2nd array
             rightmax_idx = 4th index of 2nd array.
             ie means : 2nd array should be cut after 19 as total elements in that case
             will become 6 and both arrays will be partitioned in 2 parts of equal size.
             Keep on doing it unless you found a perfect cut with the following conditions
             leftmin <= right_max && left_max  >= right_min
            *
            *
            */
            partition_nums2 = mid_for_both_arr - mid;
            /* take care of all indexes, */
            left_min = (mid != 0) ? nums1[mid - 1] : INT_MIN;
            left_max = (mid != len1) ? nums1[mid] :  INT_MAX;
            
            right_min = (partition_nums2 != 0) ? nums2[partition_nums2 - 1] :  INT_MIN;
            right_max = (partition_nums2 != len2) ? nums2[partition_nums2] :  INT_MAX;
            
            /* Found a median */
            if (left_min <= right_max && left_max >= right_min) {
                if (is_even) {
                    median = (max(left_min,right_min) + min(left_max,right_max)) / 2.0;
                } else {
                    median = max(left_min,right_min);
                }
                break;
            } else {
                /* It means we need to move left side */
                if (left_min > right_max) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return median;
    }

};


/* Execute on leetcode platform */


