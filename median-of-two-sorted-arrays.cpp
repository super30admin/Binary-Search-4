// TC: O(log(min(m, n)))
// SC: O(m + n + 1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // partition algo - nums1 = l1 + r1; nums2 = l2 + r2
        //  median will be towards the mid, so find the right partition using BS
        // null
        if(nums1.size() == 0 && nums2.size() == 0) return 0.0;
        int n1 = nums1.size(), n2 = nums2.size();
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;
        while(low <= high) {
            int px = low + (high - low) / 2;
            int py = (n1 + n2) / 2 - px; //makes sure there is 1 extra ele in right side
            int l1 = (px == 0) ? INT_MIN : nums1[px - 1];
            int l2 = (py == 0) ? INT_MIN : nums2[py - 1];
            int r1 = (px == n1) ? INT_MAX : nums1[px];
            int r2 = (py == n2) ? INT_MAX : nums2[py];
            if(l1 <= r2 && l2 <= r1) { // correct partition
                if((n1 + n2) % 2 == 0) // even
                    return (double)(max(l1, l2) + min(r1, r2)) / 2;
                else // odd
                    return min(r1, r2); // as 1 extra element in right partition
            }
            else if(l2 > r1) low = px + 1;
            else high = px - 1;
        }
        return 0.0;
    }
};