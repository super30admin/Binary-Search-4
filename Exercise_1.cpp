// Time Complexity : O(mlogm + nlogn) where m and n are the sizes of the two input arrays. This is due to the sorting step.
// Space Complexity : O(1) 
// Were you able to solve it on Leetcode : Yes
// Any problem you faced while coding this : Understanding the binary search to find the first occurrence of the target

class Solution {
public:

    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {

        if (nums1.empty() || nums2.empty() ){
            return {};
        }

        int m = nums1.size(), n=nums2.size();

        if(m>n){
            // we choose the larger array to do binary search
            return intersect(nums2, nums1);
        }

        // Need to Sort arrays for binary search and linear scan
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        // init low to 0 and high to the last element of the larger array for binary search
        int low = 0, high = n-1;
        vector<int> result;
        for (int num: nums1){
            // we linearly traverse across nums1 (smaller array) and perform binary search over nums2 (larger array)
            int bstIndex = searchIndex(num, nums2, low, high);

            // if we found the element, we add it to the result and update low to bstIndex+1
            // this is to avoid counting duplicates
            if (bstIndex !=-1){
                result.push_back(num);
                low = bstIndex+1;
            }
        }
        
        vector<int> re(result.size());
        for(int i = 0; i < result.size(); i++){
            re[i] = result[i];
        }

        return re;

    }

private:
    int searchIndex(int target, vector<int>& nums, int low, int high){

        // standard binary search with a slight modification to find the first occurrence of the target
        while (low<=high){


            int mid = low + (high-low) / 2;

            // if mid is the target, we check if it's the first occurrence
            if (nums[mid] == target){
                // check if mid is the first occurrence
                if (low == mid || nums[mid-1] != nums[mid]){
                    // if mid is the first occurrence, return mid
                    return mid;
                }
                // else, we continue searching in the left half
                high = mid - 1;
            }
            // if mid is greater than target, we search in the left half
            else if (nums[mid] > target){
                high = mid - 1;
            }
            // if mid is less than target, we search in the right half
            else{
                low = mid + 1;
            }

        }
        // if we don't find the target, return -1
        return -1;
    }
};