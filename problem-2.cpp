class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size(),m=nums2.size();
        nums1.insert(nums1.end(),nums2.begin(),nums2.end());
        sort(nums1.begin(),nums1.end());
        float f=0;
        if((n+m)%2==0)
        {
            f= nums1[(nums1.size()-1)/2]+nums1[((nums1.size()-1)/2)+1];
            return f/2;
        }
        return nums1[(nums1.size()-1)/2];
    }
};
