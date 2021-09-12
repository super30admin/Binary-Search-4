// Time Complexity : O(N + M)
// Space Complexity :O(N) where N is the length of the smallest array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.empty() || nums1.size()==0)
            return nums1;
        if(nums2.empty() || nums2.size()==0)
            return nums2;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2)
            return intersect(nums2, nums1);
        unordered_map<int, int> map;
        for(int num : nums1){
            if(map.find(num) != map.end())
                map[num] += 1;
            else{
                map.insert({num, 1});
            }
        }
        vector<int> result;
        for(int i=0; i<n2; i++){
            if(map.find(nums2[i]) != map.end() && map[nums2[i]] >0){
                result.push_back(nums2[i]);
                map[nums2[i]] -= 1;
            }
            if(map.size() == 0)
                break;
        }
        return result;
        
    }
};


// Time Complexity : O(NlogN + MlogM)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.empty() || nums1.size()==0)
            return nums1;
        if(nums2.empty() || nums2.size()==0)
            return nums2;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2)
            return intersect(nums2, nums1);
        // binary search
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int low = 0;
        int high = n2 - 1;
        vector<int> result;
        for(int i=0; i<n1; i++){
            int val = binarySearch(nums2, low, high, nums1[i]);
            if(val != -1){
                result.push_back(nums1[i]);
                low = val + 1;
            }
        }
        return result;
    }
    int binarySearch(vector<int>& nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if((mid == low) || (nums[mid] != nums[mid - 1]))
                    return mid;
                high = mid - 1;
            }
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid + 1;
        }
        return -1;
    }
};


// Time Complexity : O(N + M)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.empty() || nums1.size()==0)
            return nums1;
        if(nums2.empty() || nums2.size()==0)
            return nums2;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2)
            return intersect(nums2, nums1);
        // 2 pointer
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int p1=0, p2=0;
        vector<int> result;
        while(p2 < n2 && p1 < n1){
            if(nums1[p1] == nums2[p2]){
                result.push_back(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] > nums2[p2])
                p2++;
            else
                p1++;
        }
        
        return result;
    }
};


