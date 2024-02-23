// TC = O(M + N)
//  SC = O(M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    // TC = O(M + N), SC = O(M)
    // vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    //     if(nums1.size() > nums2.size()) return intersect(nums2, nums1);
    //     unordered_map<int, int> map;
    //     for(int num: nums1) map[num]++;
    //     vector<int> result;
    //     for(int i = 0; i < nums2.size(); i++) {
    //         if(map[nums2[i]]-- > 0) result.push_back(nums2[i]);
    //     }
    //     return result;
    // }

    // vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    //     // follow up, what if the arrays are sorted -> use 2 pointer approach
    //     sort(nums1.begin(), nums1.end());
    //     sort(nums2.begin(), nums2.end());
    //     int p1 = 0, p2 = 0;
    //     vector<int> res;
    //     while(p1 < nums1.size() && p2 < nums2.size()) {
    //         if(nums1[p1] == nums2[p2]) {
    //             res.push_back(nums1[p1]);
    //             ++p1; ++p2;
    //         }
    //         else if(nums1[p1] < nums2[p2]) ++p1;
    //         else ++p2;
    //     }
    //     return res;
    // }

    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        // follow up, what if the arrays are sorted -> use BS, TC = O(MlogN);
        if(nums1.size() > nums2.size()) return intersect(nums2, nums1);
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int index = 0;
        vector<int> res;
        for(int i = 0; i < nums1.size(); i++) {
            int bsIndex = binarySearch(nums2, index, nums1[i]);
            if(bsIndex < nums2.size() && nums2[bsIndex] == nums1[i]) {
                res.push_back(nums1[i]);
                index = bsIndex + 1; // search from this index for next call
            }
        }
        return res;
    }
    int binarySearch(vector<int>& nums, int index, int target) {
        int left = index, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
};