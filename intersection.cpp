/*  Time : O(NLogN)
    Space : O(1)
    Leetcode : Yes
    Explanation : Maintain 3 pointers, 2 for read from each array and one to write
    into array 1. Move ptr1, ptr2 such that they point to equal elements.
    Write this into array 1 and move to next elements.
*/
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        // Sort the vector
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        // Index 1, 2 for each of the vectors,3 for writing into array 1
        int idx1 = 0, idx2 = 0, idx3 = 0;
        
        while(idx1 < nums1.size() && idx2 < nums2.size())
        {
            if(nums1[idx1] < nums2[idx2])
            {
                idx1++;
            }
            else if(nums1[idx1] > nums2[idx2])
            {
                idx2++;
            }
            else
            {
                nums1[idx3++] = nums1[idx1++];
                idx2++;
            }
        }
        
        return vector<int>(nums1.begin()+0, nums1.begin()+idx3);
        
    }
};