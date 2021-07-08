// Time Complexity : O(m+n)
// Space Complexity :  O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        int len1 = nums1.size();
        int len2 = nums2.size();
        int i;
        
        map<int, int> m1;
        map<int, int> m2;
        
        vector<int> ret_vect;
        
        for(i = 0; i < len1; i++)
        {
            if(m1.find(nums1[i]) == m1.end())
                m1.insert(pair<int, int>(nums1[i], 1));
            else
                m1[nums1[i]] += 1;
        }
        
        for(i = 0; i < len2; i++)
        {
            if(m2.find(nums2[i]) == m2.end())
                m2.insert(pair<int, int>(nums2[i], 1));
            else
                m2[nums2[i]] += 1;
        }
        
        map<int, int>::iterator itr;
        int t1, t2, t;
        
        for(itr = m1.begin(); itr != m1.end(); itr++)
        {
            if(m2.find(itr->first) != m2.end())
            {
                t1 = itr->second;
                t2 = m2[itr->first];
                
                t = min(t1, t2);
                
                for(i = 0; i < t; i++)
                    ret_vect.push_back(itr->first);
            }
            
        }
        
        return ret_vect;
    }
};