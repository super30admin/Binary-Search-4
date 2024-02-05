// Time Complexity : O(log(n-k)) - BS is done on n-k elements only

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using binary search, to look for the start point from the target.

#include <bits/stdc++.h>
using namespace std;

class Solution {
    private:
    int binarySearch(vector<int>& nums2,int low,int high,int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums2[mid] == target){
                // if it the first occurance
                if(mid == low || nums2[mid] > nums2[mid-1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums2[mid] < target){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> ans;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        if(nums1.size() > nums2.size()){
            return intersect(nums2,nums1);
        }
        int low = 0,high = nums2.size()-1;
        for(int i=0;i<nums1.size();i++){
            int bsIdx = binarySearch(nums2,low,high,nums1[i]);
            if(bsIdx != -1){
                ans.push_back(nums1[i]);
                low = bsIdx+1;
            }
        }
        return ans;
    }
};