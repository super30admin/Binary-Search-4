#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We do binary search on the smaller array to partition both arrays correctly.
At each step, we ensure the left side max ≤ right side min for both arrays.
If total length is odd, the extra element is always kept on the right side and we return the median based on even/odd total length
*/
class Solution{
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2){
        int n1 = nums1.size(), n2 = nums2.size();
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = ((n1 + n2 + 1)/2) - partX;

            double L1 = (partX == 0) ? INT_MIN : nums1[partX - 1];
            double R1 = (partX == n1) ? INT_MAX : nums1[partX];
            double L2 = (partY == 0) ? INT_MIN : nums2[partY - 1];
            double R2 = (partY == n2) ? INT_MAX : nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2)%2 == 0) return (max(L1, L2) + min(R1, R2))/2.0;
                else return max(L1, L2);
            }else if(L2 > R1) low = partX + 1;
            else high = partX - 1;
        }
        return -1;
        
    }
};
