/*
    **Time Complexity (TC):** O(log(min(n1, n2)))

    **Space Complexity (SC):** O(1)

    Where:
    - `n1` is the size of `nums1`.
    - `n2` is the size of `nums2`.
*/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        if(n1==0 && n2==0) {
            return 0.0;
        }
        if(n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n1;
        while(low <= high) {
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double l1 = partX == 0 ? INT_MIN : nums1[partX - 1];
            double l2 = partY == 0 ? INT_MIN : nums2[partY - 1];
            double r1 = partX == n1 ? INT_MAX : nums1[partX];
            double r2 = partY == n2 ? INT_MAX : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2) % 2 != 0) {
                    return min(r1,r2);
                } else {
                    return (max(l1,l2) + min(r1,r2))/2.0;
                }
            } else if(l2 > r1) {
                low = partX+1;
            } else {
                high = partX-1;
            }
        }
        return 0;
    }
};