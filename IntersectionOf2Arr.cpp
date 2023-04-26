// Approach - HashMap
// Time complexity - O(m+n)
// Space complexity - O(min(m, n))
// It runs on leetcode.
// Problems faced - No!
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums2.size() > nums1.size())
            return intersect(nums2, nums1);
        
        unordered_map<int, int> map;
        for(int i = 0; i < nums1.size(); i++)
            map[nums1[i]]++;
        
        vector<int> answer;
        for(int i = 0; i < nums2.size(); i++){
            if(map.count(nums2[i]) && map[nums2[i]] != 0){
                answer.push_back(nums2[i]);
                map[nums2[i]]--;
            }
        }
        return answer;
    }
};

// Approach - Given arrays are sorted
// Time Complexity - O(m+n)
// Space Complexity - O(1)
// It runs on Leetcode!
// Problems Faced - No!
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int p1 = 0;
        int p2 = 0;
        vector<int> answer;
        while(p1 < nums1.size() && p2 < nums2.size()){
            if(nums1[p1] == nums2[p2]){
                answer.push_back(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }
        return answer;
    }
};

// Approach - Binary Search(Assume given arrays are sorted)
class Solution {
    int bSearch(vector<int>& nums, int target, int start){
        int low = start;
        int high = nums.size() - 1;
        int mid;
        
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target && (mid == low || nums[mid - 1] != target))
                return mid;
            else if(nums[mid] >= target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() < nums2.size())
            return intersect(nums2, nums1);
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        vector<int> answer;
        
        int ptr1 = -1;
        int ptr2 = 0;
        
        while(ptr2 < n2){
            int curr = nums2[ptr2];
            int idx = bSearch(nums1, curr, ptr1 + 1);
            if(idx != -1){
                ptr1 = idx;
                answer.push_back(curr);
            }
                ptr2++;
        }
        return answer;
    }
};