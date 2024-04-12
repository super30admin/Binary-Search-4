class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        if(m > n) return intersect(nums2, nums1);
        vector<int> ans;
        unordered_map<int,int> imap;
        for(int i = 0; i < m; i++)
            imap[nums1[i]]++;
        for(int i = 0; i < n; i++)
        {
            if(imap.find(nums2[i])!= imap.end())
            {
                if(imap[nums2[i]] > 0)
                {
                    ans.push_back(nums2[i]);
                    imap[nums2[i]]--;
                }
                
            }
        }
        return ans;
    }
};
