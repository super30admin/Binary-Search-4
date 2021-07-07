// First solution
// We can have a hashmap solution - go thru smaller array and maintain count of each ele
// then go thru smaller array and add common els, reduce count in map and remove entry if count=0
// time: O(max(m,n))
// space: O(mins(m,n)) // here made space efficient since larger maps will make time even more inefficient

// Second solution
// 2 pointers 
// Time Complexity : O(max(m,n)) ; if already sorted
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain two pointers, one at start of each array
// 2. If elements pointed by both pointers are same then add that to the result and advance both pointers
// 3. Else advance the pointer pointing to the smaller element 

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result;
        if(!nums1.size() || !nums2.size())
            return result;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        int first=0,second=0;
        while(first<nums1.size() && second<nums2.size()){
            if(nums1[first]==nums2[second]){
                result.emplace_back(nums1[first]);
                first++; second++;
            }
            else if(nums1[first]<nums2[second])
                first++;
            else
                second++;
        }
        return result;
    }
};

// Binary search solution
// Time Complexity : O(nlogm) n-sizeof smaller array, m-sizeof larger array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Iterate through smaller array and search every element in the larger array (search first occurence)
// 2. Take care to send where to start searching to avoid duplicates
// 3. mid>start condition is for cases like nums1=[1,2,2,1], nums2=[2,2]

// If nums1 and nums2 are of very different sizes then binary search helps in reducing time complexity by searching over larger one
// If there is memory constraint, then BS solution is better since we don't need to load the entire larger array in memory, just send one by one


class Solution {
public:
    int binSearch(vector<int>& nums, int start, int target){
        int low=start, high=nums.size()-1;
        while(low<=high){
            int mid = low +(high-low)/2; // to prevent overflow
            if(target == nums[mid]){
                if(mid>start && nums[mid]==nums[mid-1])
                    high = mid-1;
                else 
                    return mid;
            }
            else if(target<nums[mid])
                high=mid-1;
            else 
                low=mid+1;            
        }
        return -1;
    }
    
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result;
        if(!nums1.size() || !nums2.size())
            return result;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        // Assuming nums1 is longer; thus pass it to binSearch
        
        // But if its not true, call the function with swapped
        if(nums2.size()>nums1.size())
            return intersect(nums2, nums1);
        
        // search every el of nums2 in nums1
        int start = 0;
        for(auto el: nums2){
            int index = binSearch(nums1,start,el);
            if(index!=-1){
                result.emplace_back(el);
                start=index+1;
            }
        }
        return result;
    }
};