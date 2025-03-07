// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

// hashmap
// Time Complexity : O(n+m)
// Space Complexity : O(min(n,m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Push the elements of the smaller array into a hashmap
// Iterate through the other array, check if the element is present. If yes, decrease the count and add it to the resultant array

class Solution {
    public:
        vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
            int n1=nums1.size();
            int n2=nums2.size();
            vector<int> ans;
            if(n1>n2) return intersect(nums2,nums1);
            unordered_map<int,int> m;
            for(auto i:nums1){
                m[i]++;
            }
            for(auto i:nums2){
                if(m[i] > 0){
                    ans.push_back(i);
                    m[i]--;
                }
            }
    
            return ans;
        }
    };


// Two pointer
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Put two pointers at the beginning of both the arrays. 
// If the values are equal, push them into the resultant array, increment both pointers.
// If the value at first array is smaller, then increment that pointer. Else increment the second pointer.

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size();
        int n2=nums2.size();
        vector<int> ans;
        if(n1>n2) return intersect(nums2,nums1);
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int p1=0; int p2=0;
        while(p1<n1 && p2<n2){
            if(nums1[p1] == nums2[p2]){
                ans.push_back(nums1[p1]);
                p1++; p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        return ans;
    }
};


// Bianry Search
// Time Complexity : O(min(n,m) log max(n,m))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Consider the smaller array and perform binary search of each element in the other array.
// Find out the leftmost element and add it to the resultant array if found in both arrays.


class Solution {
    public:
        int BS(vector<int>& nums2, int low, int high, int target){
            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums2[mid] == target){
                    if(mid == low || nums2[mid] > nums2[mid-1]) return mid;
                    else high = mid-1;
                } 
                else if(nums2[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            return -1;
        }
        vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
            int n1=nums1.size();
            int n2=nums2.size();
            vector<int> ans;
            if(n1>n2) return intersect(nums2,nums1);
            sort(nums1.begin(), nums1.end());
            sort(nums2.begin(), nums2.end());
            int low=0; int high=n2-1;
            for(int i=0; i<n1; i++){
                int target=nums1[i];
                int idx = BS(nums2, low, high, target);
                if(idx != -1){
                    ans.push_back(target);
                    low = idx+1;
                }
            }
            return ans;
        }
    };