// Time Complexity : O(nlog(m)) where m - smaller array

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using binary search, to create partitions in both the arrays
// to find the median.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low+(high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int l1 = partX == 0 ? INT_MIN : nums1[partX-1];
            int l2 = partY == 0 ? INT_MIN : nums2[partY-1];
            int r1 = partX == n1 ? INT_MAX : nums1[partX];
            int r2 = partY == n2 ? INT_MAX : nums2[partY];
            if(l1 <= r2 && l2 <= r1){
                // correct partition found
                if((n1+n2)%2 == 0){
                    return (max(l1,l2) + min(r1,r2))/2.0;
                }
                else{
                    return min(r1,r2);
                }
            }
            else if(l2 > r1){
                low = partX + 1;
            }
            else{
                high = partX - 1;
            }
        }
        return 7346786.234677;
    }
};