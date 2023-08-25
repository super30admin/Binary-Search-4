//time: O(m+n);
//space:O(m);

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int,int> map;

        vector<int> result;

        int n = nums1.size();
        int m = nums2.size();

        for(int i=0;i<n;i++){
            if(map.find(nums1[i])!=map.end()){
                map[nums1[i]]++;
            }
            else{
                map[nums1[i]]=1;
            }


        }

        for(int i=0;i<m;i++){
            if(map.find(nums2[i])!=map.end()){
                result.push_back(nums2[i]);
                map[nums2[i]]--;
            }

            if(map[nums2[i]]==0){
                map.erase(nums2[i]);
            }
        }

        return result;


        
    }
};