//TC: O(m + n) where m,n are sizrs of nums1, nums2 respectively
//SC: O(min(m, n))

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        unordered_map<int, int> map;
        
        vector<int> common;
            
        if(nums1.size() > nums2.size())
            return intersect(nums2, nums1);
        
        for(int i=0; i<nums1.size(); i++){
            map[nums1[i]]++;
        }
        
        for(int i=0; i<nums2.size(); i++){
            if(map.find(nums2[i])!=map.end()){
                if(map[nums2[i]]>0){
                    common.push_back(nums2[i]);
                    map[nums2[i]]--;
                }
            }
        }
        
        return common;
        
        
    }
};