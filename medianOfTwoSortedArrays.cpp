//time complexity:O(m+n)
//space complexity:O(m+n)
//executed on leetcode: yes
//approach:using brute force
//any issues faced? yes, dont know the optimized way

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m=nums1.size();
        int n=nums2.size();
        vector<int>res;
        int i=0; int j=0;
        for(;i<m and j<n;)
        {
            if(nums1[i]<nums2[j])
            {
                res.push_back(nums1[i]);
                i++;
            }
            else
            {
                res.push_back(nums2[j]);
                j++;
            }
        }
        for(;i<m;i++)
            res.push_back(nums1[i]);
        for(;j<n;j++)
            res.push_back(nums2[j]);
        int r=res.size();
        // for(int i=0; i<r; i++)
        //     cout<<res[i]<<" ";
        if(r%2!=0)
            return (double)res[r/2];
        else
        {
            return (double)(res[r/2]+res[r/2 -1])/2;
        }
    }
};