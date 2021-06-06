// Time Complexity :O(log n) assuming nums1 & nums2 is already sorted
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        if(nums1.size() > nums2.size()) return intersect(nums2,nums1);
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int low =0;
        for(auto num : nums1){
            int index = searchForMatch(nums2,num,low,nums2.size()-1);
            if(index != -1){
                ans.push_back(num);
                low = index+1;
            }    
        }
        return ans;
    }
    int searchForMatch(vector<int> nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid-1] != target)
                    return mid;
                else high = mid-1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
};