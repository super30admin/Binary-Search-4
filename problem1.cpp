// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// use a map to maintain frequency of elements and then proceed.

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) return intersect(nums2,nums1);
        unordered_map<int,int>mp;
        for(int i = 0;i<nums1.size();i++)
        {
            mp[nums1[i]]++;
        }
        vector<int>result;
        for(int i = 0;i<nums2.size();i++)
        {
            if(mp[nums2[i]] > 0){
                result.push_back(nums2[i]);
                mp[nums2[i]]--;
            }
        }
        return result;
    }
};

// Follow up:

// What if the given array is already sorted? How would you optimize your algorithm?

// if given arrays are already sorted, we can use two-pointer technique .
// TC: O(min(m,n))
// SC: O(1)

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        vector<int>result;
        int p1 = 0,p2 = 0;
        while(p1<nums1.size() && p2<nums2.size())
        {
            if(nums1[p1]==nums2[p2])
            {
                result.push_back(nums1[p1]);
                p1++;p2++;
            }
            else if(nums1[p1]<nums2[p2])
            {
                p1++;
            }
            else{
                p2++;
            }
        }
        return result;
    }
};


// Follow up:
// What if nums1's size is small compared to nums2's size? Which algorithm is better?

// we traverse over smaller array to find element in the larger arrray using binary search.but the 
// previous approach is better in terms of time and space complexity.
// TC: O(nlogm) where n<m
// SC: O(1)

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) return intersect(nums2,nums1);
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        
        vector<int>result;
        int lo = 0,hi = nums2.size()-1;
        for(int i = 0;i<nums1.size();i++)
        {
            int idx = find(nums2,nums1[i],lo);
            if(idx!=-1)
            {
                result.push_back(nums1[i]);
                lo = idx+1;
            }
            
        }
        return result;
    }
    int find(vector<int>&nums2, int target,int lo)
    {
        int ans = -1;
        int hi = nums2.size()-1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(target == nums2[mid])
            {
                if(mid == lo || nums2[mid]!=nums2[mid-1]) return mid;
                hi = mid -1;
            }
            else if (target < nums2[mid])
            {
                hi = mid-1;
            }
            else {
                lo = mid +1;
            }
        }
        return ans;
    }
};

// Follow up:
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
// we can do the same approaches but we perform operations each time on chuncks of data of nums2.
