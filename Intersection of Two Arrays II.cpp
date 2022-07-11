//Time Complexity- O(min(m,n)log(max(m,n)))
//Space Complexity- O(1)

class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        
        if(nums1.size()==0 || nums2.size()==0){
            return {};
        }
        
        if(nums1.size()>nums2.size()){
            return intersect(nums2,nums1);
        }
        
        vector<int> ans;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        
        int low=0;
        for(int i=0;i<nums1.size();i++){
            
            int idx=find(nums1[i],nums2,low,nums2.size()-1);
            if(idx!=-1){
                ans.push_back(nums1[i]);
                low=idx+1;
            }
        }
        return ans;
    }
    
    int find(int val,vector<int> &nums,int low,int high){
        
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==val){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]>val){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
};