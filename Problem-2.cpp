// https://leetcode.com/problems/median-of-two-sorted-arrays/
// Time Complexity : O(log (min(n,m)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Calculate the partition of smallest array and based on it calculate the partition of the other array.
// The left partition will have L1 & L2 and the right will be R1 & R2. If L1<= R2 && L2<=R1 return the median 
// which is if even then average of max of L1,L2 and min of R1,R2. Else, min of R1,R2.
// Else move low and high accordingly.


class Solution {
    public:
        double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
            int n1 = nums1.size();
            int n2 = nums2.size();
            if(n1 == 0 && n2 == 0) return 0.0;
            if(n1>n2) return findMedianSortedArrays(nums2, nums1);
            int low = 0; int high = n1;
            while(low <= high){
                int partX = low + (high-low)/2;
                int partY = (n1+n2)/2 - partX;
                int L1 = partX == 0 ? INT_MIN:nums1[partX-1];
                int L2 = partY == 0 ? INT_MIN:nums2[partY-1];
                int R1 = partX == n1 ? INT_MAX:nums1[partX];
                int R2 = partY == n2 ? INT_MAX:nums2[partY];
                if(L1 <= R2 && L2 <= R1){
                    if((n1+n2)%2 == 0) return (max(L1,L2) + min(R1,R2))/2.0;
                    else return min(R1,R2);
                }
                else if(L1>R2){
                    high = partX-1;
                }
                else{
                    low = partX+1;
                }
            }
            return 0;
        }
    };