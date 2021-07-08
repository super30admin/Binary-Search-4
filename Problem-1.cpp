//O(m+n) TC and SC
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> dict;
        vector<int> res;
        for(int i = 0; i < (int)nums1.size(); i++) 
            dict[nums1[i]]++;
        for(int i = 0; i < (int)nums2.size(); i++)
            if(dict.find(nums2[i]) != dict.end() && --dict[nums2[i]] >= 0) res.push_back(nums2[i]);
        return res;
    }
};
            
/*non h_map;*/
  //O(m+n) TC, O(1) SC         
/*vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        vector<int>ans;
        sort(nums1.begin(),nums1.end());sort(nums2.begin(),nums2.end());
        int len1 = nums1.size(),len2 = nums2.size(),i=0,j=0;
        while(i<len1 && j<len2){
            if(nums1[i] == nums2[j]){
                ans.push_back(nums1[i]);
                i++;j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
        }
        return ans;
    }*/
