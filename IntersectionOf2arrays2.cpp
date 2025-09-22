#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use two pointers to traverse through both the arrays at the same time, we check
which array is smaller and traverse through it first to save time and push the if the
element is equal in both the array into one result vector and finally return the result vector
*/
class Solution{
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2){
        int n1 = nums1.size(), n2 = nums2.size();
        if(n1 > n2){
            return intersect(nums2, nums1);
        }

        vector<int> result;
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());

        int p1=0, p2=0;
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                result.push_back(nums1[p1]);
                p1++; p2++;
            }else if(nums1[p1] > nums2[p2]) p2++;
            else p1++;
        }

        return result;
    }
};
