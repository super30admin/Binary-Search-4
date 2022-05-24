/* 
    Time Complexity                              :  twoPointer approach --> O(Log N) + O(Log M) 
                                                    where N and M are the sizes of nums1 and nums2 
                                                    mapApproach --> max of O(N) and O(M) 
    Space Complexity                             :  O(1) for twoPointerApproach
                                                    O(N) - for mapApproach
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std; 


class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        // return twoPointer(nums1, nums2);
        return mapApproach(nums1, nums2);
    }
    
    
    vector<int> twoPointer(vector<int>& nums1, vector<int>& nums2) {
        sort(begin(nums1), end(nums1));
        sort(begin(nums2), end(nums2));
        int i=0,j=0,k=0;
        while(i < nums1.size() and j < nums2.size()) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        
        return vector<int>(begin(nums1), begin(nums1)+k);
    }
    
    vector<int> mapApproach(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> mp;
        for(auto num : nums1) {
            mp[num]++;
        }
        
        int k=0;
        for(auto num : nums2) {
            if(mp.find(num) != mp.end() and --mp[num] >= 0) {
                nums1[k++] = num;
            }
        }
        
        return vector<int>(begin(nums1), begin(nums1)+k);
    }
};