// Time Complexity : O(m) + O(n)
// Space Complexity : O(min(m , n))
//      Where m, n : Length of arrays.
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build a hash map using the elements of smaller array. Hashmap stores a value and its frequency.
 * Iterate over the second array. While iterating perform the below operations.
 *         1. Check if current element is present in hash map, if it is present then add it to results and decrese the frquency of that element.
 *         2. If the frquency of element becomes zero then remove the element from map.
 */

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        if (nums1.size() == 0 | nums2.size() == 0)
            return {};
        
        if (nums1.size() > nums2.size())
            intersect(nums2, nums1);
        
        map<int, int> m;
        vector<int> results;
        
        for (auto ele : nums1)
        {
            auto e = m.find(ele);
            
            if (e == m.end())
                m.insert({ele, 1});
            else
                e->second += 1; 
        }
        
        for (auto ele : nums2)
        {
            auto e = m.find(ele);
            
            if (e != m.end())
            {
                results.push_back(ele);
                e->second -= 1;
                
                if (e->second == 0)
                    m.erase(e);
            }             
        }
        
        return results;
    }
};