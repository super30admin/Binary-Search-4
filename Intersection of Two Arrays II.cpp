// 1. 1 hash map of smaller arr
// 2. sorting -> 2 ptrs, binary search
// time: (if already sorted arr given) O(nlogm), where n: smaller arr
// space: O(1)
class Solution {
public:
    int l = 0;
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        //doing the follow up (sorted arrs - then binary search)
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        vector<int> result;
        int small = min(nums1.size(), nums2.size());
        
        for(int i = 0; i < small; i++) {
            if(nums1.size() > nums2.size()) {
                if(nums2[0] <= nums1[nums1.size()-1] && nums2[nums2.size()-1] >= nums1[0])
                binarySearch(nums2, nums1, i, l, nums1.size()-1, result); // small, big
            }
            else {
                if(nums1[0] <= nums2[nums2.size()-1] && nums1[nums1.size()-1] >= nums2[0])
                binarySearch(nums1, nums2, i, l, nums2.size()-1, result);
            }
        }
        return result;
    }
private:
    void binarySearch(vector<int>& nums1, vector<int>& nums2, int idx, int low, int high, vector<int>& result) {
        //cout<<idx<<endl;
        if(low > high) {
            return;
        }
        l = low;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums2[mid] == nums1[idx]) {
                if(mid == low || nums2[mid-1] != nums1[idx]) {
                    result.push_back(nums1[idx]);
                    l = mid+1;
                    return;
                }
                else {
                    high = mid-1;
                }
            }
            else if(nums2[mid] > nums1[idx]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        
    }
};