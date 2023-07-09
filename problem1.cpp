// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

Store the frequency of the occurences of all the values in array 1
Check the values of array 2 in array 1 and if found reduce the frequency.

*/

// using hashmap

#include<iostream>
#include<unordered_map>
#include<vector>

using namespace std;

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res{};
        unordered_map<int,int> nums1_freq{};
        for(auto& c:nums1){
            if(nums1_freq.find(c) == nums1_freq.end()){
                nums1_freq[c] = 1;
            }
            else{
                nums1_freq[c]++;
            }
        }
        for(auto& c:nums2){
            if(nums1_freq.find(c)!=nums1_freq.end() && nums1_freq.at(c)>0){
                res.push_back(c);
                nums1_freq.at(c)--;
            }
        }
        return res;
    }
};

// Time Complexity : O(NlogN) // sorting + O(NlogN) finding n elements of array 2 in array 1
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

Initially initialize the low as 0 and high as length - 1 for search array.
Search the elements of array 2 in array 1 using binary search
If repetition in array 1 then check if the last elemetn in mid-1 is not the target element. If not choose that mid value
and add that to the result. 
Update the new search area for array1 to idx given+1 so that the repeat is eliminated from the search .
Also since the array is sorted it helps avoid repition.
Do untill all elements of array 2 are iterated.

Here array1 is larger than array 2.

*/


// using binary search;

class Solution {
    int bs(vector<int>& nums1,int low,int high,int target){
        int gg_low = low;
        while(low<=high){
            int mid = low + (high - low)/2;
            //cout<<"Target "<<target<<"mid_value "<<mid<<"nums_val "<<nums1.at(mid)<<"low_val "<<low<<endl;
            if(nums1.at(mid) == target){
                if(mid == gg_low) return mid;
                if(nums1.at(mid-1)!= target) return mid;
            }
            if(nums1.at(mid)>=target){
                high = mid - 1;
                //cout<<"change high"<<endl;
            }
            else {
                low = mid + 1;
                //cout<<"change low"<<endl;
            }    
        }
        return -1;
    }

public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> res{};
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n2>n1) return intersect(nums2,nums1);
        int low{},high{n1-1};
        for(int i{};i<n2;++i){
            int target = nums2.at(i);
            int idx = bs(nums1,low,high,target);
            if(idx != -1){
                res.push_back(nums1.at(idx));
                low = idx+1;
            }
            cout<<i<<" "<<low<<endl;
        }
        return res;
    }
};