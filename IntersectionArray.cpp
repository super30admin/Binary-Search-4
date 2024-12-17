class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        if(nums2.size() < nums1.size())
            intersect(nums2,nums1);
        vector<int>result;
        unordered_map<int,int>freq_map;

        for(int i : nums1)
        {
            freq_map[i]++;
        }

        for(int i : nums2)
        {
            if(freq_map.find(i) != freq_map.end())
            {
                result.push_back(i);
                freq_map[i]--;
                if(freq_map[i] == 0)
                    freq_map.erase(i);
            }
        }
        return result;
    }
};
//Time complexity is O(m+n)
//space complexity is O(n)