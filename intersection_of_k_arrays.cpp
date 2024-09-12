class Solution {
public:
    //Two pointers solution
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2){
        if(nums1.size()==0||nums2.size()==0)
            return {};
        vector<int>v;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int index=0;
        for(int i=0;i<nums1.size();i++)
        {
            int b_index=binarysearch(nums2,nums1[i],index);
            if(b_index!=-1)
            {
                v.push_back(nums1[i]);
                index=b_index+1;
            }
        }        
        return v;
    }
    int binarysearch(vector<int>nums,int target,int index)
    {
        int low=index,high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==low || nums[mid]>nums[mid-1])
                    return mid;
                else
                    high=mid-1;
            }
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
};

class Solution {
public:
	//Hashmap solution
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2){
        if(nums1.size()==0||nums2.size()==0)
            return {};
        unordered_map<int,int>m;
        for(int x:nums1)
            m[x]++;
        vector<int>v;
        for(int x:nums2)
        {
            if(m.count(x))
            {
                v.push_back(x);
                m[x]--;
                if(m[x]==0)
                    m.erase(x);
            }
        }
        return v;
    }
};