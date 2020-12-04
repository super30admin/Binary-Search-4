/* Problem Statement:
https://leetcode.com/problems/intersection-of-two-arrays-ii/

350. Intersection of Two Arrays II
Easy
 Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?




 * Solution 1 : Sort arrays and then use 2 pointer approach to find the elements 
 * Time Complexity : O(nlogn) where n is size of bigger array , individual operations include sorting and then searching   
 * Space complexity : O(1) excluding result array  

 * Solution 2: Use  2 hash maps to store array elements. search 1st hash elem in 2nd hash set and store the minimum frequency
    of the number found.
 * Time Complexity: O(m+n)
 * Space complexity : O(m+n) where m is size of the larger array 
 */

class Solution {
public:
    /* Sort and then use 2 pointer approach solution */
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1_idx = 0, n2_idx = 0;
        int n1_len = nums1.size();
        int n2_len = nums2.size();
        vector<int> result;
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        while(n1_idx < n1_len && n2_idx < n2_len) {
            if (nums1[n1_idx] == nums2[n2_idx]) {
                result.push_back(nums1[n1_idx]);
                n1_idx++;n2_idx++;
            } else if (nums1[n1_idx] > nums2[n2_idx]){
                n2_idx++;
            } else {
                n1_idx++;
            }
        }
        return result;
    }

    /* Hash table solution */
    vector<int> intersect_ver2(vector<int>& nums1, vector<int>& nums2) {
        int n1_idx = 0, n2_idx = 0;
        int n1_len = nums1.size();
        int n2_len = nums2.size();
        vector<int> result;
        
        unordered_map<int,int> hmap1;
        unordered_map<int,int> hmap2;
        
        /* copy 1st array to hashmap */
        for (int idx = 0; idx < n1_len; idx++) {
            hmap1[nums1[idx]]++;
        }
        /* 2nd array to hash map */
        for (int idx = 0; idx < n2_len; idx++) {
            hmap2[nums2[idx]]++;
        }
        unordered_map<int,int>::iterator hmap1_iter;
        for (hmap1_iter= hmap1.begin(); hmap1_iter != hmap1.end(); hmap1_iter++) {
            unordered_map<int,int>::iterator hmap2_iter = hmap2.find(hmap1_iter->first);
            /* if number found, take the minimum freq and then add that many times the number in result */
            if (hmap2_iter != hmap2.end()) {
                int freq = min(hmap1_iter->second,hmap2_iter->second);
                for (int idx = 0; idx < freq;idx++)
                    result.push_back(hmap1_iter->first);                 
            }
       
        }
        return result;
    }
};

/* Execute on leetcode platform */


