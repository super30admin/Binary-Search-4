// Problem: Intersection of Two Arrays II
// Time complexity: O(n + m), where n and m are the sizes of the two input arrays.
// Space complexity: O(min(n, m)), as we are using a hash map to store
// Did this code run successfully on LeetCode? Yes

// Approach:
// We will use a hash map to store the frequency of each element in the first array.
// Then, we will iterate through the second array and check if the element exists in the hash map.
// If it does, we will add it to the result and decrement its frequency in the hash map.

#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result; 
        unordered_map<int, int> freq;
        for(auto it: nums1){
            freq[it]++;
        }

        for(auto it: nums2){
            if(freq[it] > 0){
                result.push_back(it);
                freq[it]--;
            }
        }
        return result;
    }
};