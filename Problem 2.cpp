//Time Complexity : O(nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    //binary search solution
    int bin_search(vector<int>& nums2, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums2[mid]==target){
                if( low==mid || nums2[mid-1]<target)
                    return mid;
                else
                    high = mid-1;
            }

            else if(nums2[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
    
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end()); sort(nums2.begin(), nums2.end());
        vector<int> res;
        int n1 = nums1.size(); int n2 = nums2.size();
        if(n1>n2) return intersect(nums2, nums1);
            
        int idx =0;
        for(int num:nums1){
            int n = bin_search(nums2, idx, nums2.size()-1, num);
            if(n!=-1){
                res.push_back(num);
                idx=n+1;
            }
        }
        
        return res;
    }
};