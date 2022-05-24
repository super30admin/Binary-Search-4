/* 
    Time Complexity                              :  O(Log (m)) where m is the size of the smallest of the 2 arrays
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size(), n2=nums2.size();
        if(n1 <= n2) {
            return med(nums1, nums2);
        } else {
            return med(nums2, nums1);
        }
    }
    
    double med(vector<int>& a, vector<int>& b) {
        int n = a.size(), m = b.size();
        int l = 0, r = n;
        
        while(l <= r) {
            int pa = l + (r - l)/2;
            int pb = (m+n+1)/2 - pa;
            
            int l1 = (pa == 0) ? INT_MIN : a[pa - 1];
            int l2 = (pb == 0) ? INT_MIN : b[pb - 1];
            int r1 = (pa == n) ? INT_MAX : a[pa];
            int r2 = (pb == m) ? INT_MAX : b[pb];
            
            if(l1 <= r2 and l2 <= r1) {
                if((m+n)%2 == 0) {
                    return (double)(max(l1,l2) + min(r1,r2))/2.0;
                } else {
                    return (double)(max(l1,l2));
                }
            } else if (l1 >= r2) {
                r = pa - 1;
            } else {
                l = pa + 1;
            }
        }
       return -1.0;
        
    }
};