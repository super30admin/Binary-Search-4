//time complexity:O(m+n)
//space complexity:O(m)
//executed on leetcode: yes
//approach:using hash map
//any issues faced? yes, not optimized

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int,int>map;
        vector<int>res;
        for(auto&el:nums1)
            map[el]++;
        for(auto&el:nums2)
        {
            if(map[el])
            {
                map[el]--;
                res.push_back(el);
            }
        }
        return res;
    }
};

