

//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;




class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        if(nums1.size()>nums2.size())
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=nums1.size();
        //We are doing on binary search on partitions and not actual indexes therefore we did not do nums1.size()-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int l1;
            int l2;
            int r1;
            int r2;
            int partA=mid;
            int partB=(nums1.size()+nums2.size())/2-partA;
            
            if(partA==0)
            {
                l1=INT_MIN;
            }
            else
            {
                l1=nums1[partA-1];
            }
            if(partB==0)
            {
                l2=INT_MIN;
            }
            else
            {
                l2=nums2[partB-1];
            }
            
            if(partA==nums1.size())
            {
                r1=INT_MAX;
            }
            else
            {
                r1=nums1[partA];
            }
            
            if(partB==nums2.size())
            {
                r2=INT_MAX;
            }
            else
            {
                r2=nums2[partB];
            }
            if(l1<=r2 && l2<=r1)
            {
                if((nums1.size()+nums2.size())%2==0)
                {
                    return (min(r1,r2)+max(l1,l2))/2.0;
                }
                else
                {
                    return min(r1,r2);
                }
            }
            else
            {
                if(l1>r2)
                {
                    high=partA-1;
                }
                else
                {
                    low=partA+1;
                }
            }
           
            
        }
        
        return 213219.21;
    }
};