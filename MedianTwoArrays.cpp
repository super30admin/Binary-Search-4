// Time : O(log(min(n1,n2)))
// Space : O(1)

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        if (n1 == 0 && n2 == 0) {
            return 0.0;
        }
        
       
        if (n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n1;
        
        while (low <= high) {
            int PartX = low + (high - low) / 2;
            int PartY = (n1 + n2) / 2 - PartX;
            
            double L1 = PartX == 0 ? INT_MIN : nums1[PartX - 1];
            double R1 = PartX == n1 ? INT_MAX : nums1[PartX];
            double L2 = PartY == 0 ? INT_MIN: nums2[PartY - 1];
            double R2 = PartY == n2 ? INT_MAX : nums2[PartY];
            
            if (L1 <= R2 && L2 <= R1) {
                if ((n1 + n2) % 2 != 0) {
                    return min(R1, R2);
                } else {
                    return (max(L1, L2) + min(R1, R2)) / 2;
                }
            } else if (L2 > R1) {
                low = PartX + 1;
            } else {
                high = PartX - 1;
            }
        }
        
        return 8928903.39084;
        
        
        
    }
};