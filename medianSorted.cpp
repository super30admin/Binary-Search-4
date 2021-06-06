// Time Complexity :O(log(min(m,n))) where m,n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) return findMedianSortedArrays(nums2,nums1);
        int low  = 0;
        int high = nums1.size();
        int n1 = nums1.size();
        int n2 = nums2.size();
        while(low <= high){
            int mid = low + (high-low)/2;
            int partX = mid;
            int partY = (n1 + n2)/2 - partX;
            double L1 = (partX > 0)?nums1[partX-1]:INT_MIN;
            double R1 = (partX < nums1.size())?nums1[partX]:INT_MAX;
            double L2 = (partY > 0)?nums2[partY-1]:INT_MIN;
            double R2 = (partY < nums2.size())?nums2[partY]:INT_MAX;
            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2 == 0) return (max(L1,L2) + min(R1,R2))/2;
                else return min(R1,R2);
            }
            else if(L1 > R2) high = partX-1;
            else low = partX + 1;
        }
        return -1.00;
    }
};