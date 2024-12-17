class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    // Ensure nums1 is the smaller array
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.size();
        int n = nums2.size();
        int total = m + n;
        
        int low = 0, high = m;
        
        while (low <= high) {
            int i = (low + high) / 2;     // Partition for nums1
            int j = (total + 1) / 2 - i;  // Partition for nums2

            // Edge cases for partitioning
            int left1 = (i == 0) ? INT_MIN : nums1[i - 1];
            int right1 = (i == m) ? INT_MAX : nums1[i];

            int left2 = (j == 0) ? INT_MIN : nums2[j - 1];
            int right2 = (j == n) ? INT_MAX : nums2[j];

            // Check if we have found the correct partition
            if (left1 <= right2 && left2 <= right1) {
                // If total is odd, median is the max of the left partitions
                if (total % 2 == 1) {
                    return max(left1, left2);
                }
                // If total is even, median is the average of the max of the left partitions and min of the right partitions
                return (max(left1, left2) + min(right1, right2)) / 2.0;
            }
            else if (left1 > right2) {
                // Move the partition for nums1 to the left
                high = i - 1;
            } else {
                // Move the partition for nums1 to the right
                low = i + 1;
            }
        }
        
        // If the input is incorrect or invalid, return 0.0
        return 0.0;
    }
};
//Time complexity O(log(m,n))
//space complexity O(1)