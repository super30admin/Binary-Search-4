//Time Complexity : O(n+m)
//Space Complexity : O(n+m)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        float ans;
        vector<int>arr;
        int n=nums1.size(),m=nums2.size();
        int i=0,j=0;
        while(i<n&&j<m)
        {
            if(nums1[i]>nums2[j])
            {
                arr.push_back(nums2[j]);
                j++;
            }
            else
            {
                arr.push_back(nums1[i]);
                i++;
            }
        }
        while(i<n)
        {
            arr.push_back(nums1[i]);
            i++;
        }
        while(j<m)
        {
            arr.push_back(nums2[j]);
            j++;
        }
        if(arr.size()%2==0)
        {
            int m1=arr[arr.size()/2];
            int m2=arr[(arr.size()/2)-1];
            ans=(m1+m2)/2.0;
        }
        else
        {
            ans = arr[arr.size()/2];
        }
        return ans;
    }
};