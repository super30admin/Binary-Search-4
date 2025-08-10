// Time Complexity : O(log(min(m, n))) where m and n are the sizes of the two input arrays.
// Space Complexity : O(1)
// Were you able to solve it on Leetcode : Yes
// Any problem you faced while coding this : Understanding the binary search to find the correct partition

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {

        if (nums1.empty() && nums2.empty()) {
            return 0.0; // Handle edge case of both arrays being empty
        }
        // If one of the arrays is empty, we can directly return the median of the other array
        if (nums1.empty()) {
            int n = nums2.size();
            return (n % 2 == 0) ? (nums2[n/2 - 1] + nums2[n/2]) / 2.0 : nums2[n/2];
        }
        if (nums2.empty()) {
            int n = nums1.size();
            return (n % 2 == 0) ? (nums1[n/2 - 1] + nums1[n/2]) / 2.0 : nums1[n/2];
        }

        int n1 = nums1.size();
        int n2 = nums2.size();

        // perfrorm binary search on the smaller array
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);

        // init low to 0 and high to the last element of the smaller array for binary search
        int low = 0, high = n1;

        while (low<=high){

            // calculate the partition indices for both arrays
            // partX is the partition index for nums1 and partY is for nums2
            // we want to partition the arrays such that the left side of the partition of each one array 
            // contains the smaller elements as compared to the right side of the other array
            // this is done by ensuring that the left side of nums1 is less than or equal to the right side of nums2
            // and vice versa

            // partX is the number of elements in the left side of nums1 and partY is the number of elements in the left side of nums2
            // we calculate partY as (n1+n2)/2 - partX to ensure that the total number of elements in the left side of both 
            // arrays is equal to the total number of elements in the right side
            int partX = low + (high-low) /2 ;
            int partY = (n1+n2)/2 - partX;
            
            // we calculate the left and right elements of both partitions
            // l1 is the last element of the left side of nums1, r1 is the first element of the right side of nums1
            // l2 is the last element of the left side of nums2, r2 is the first element of the right side of nums2
            // we use INT_MIN and INT_MAX to handle the edge cases where the partition is at the start or end of the array
            double l1 = (partX == 0) ? INT_MIN : nums1[partX-1];
            double r1 = (partX == n1) ? INT_MAX : nums1[partX];
            double l2 = (partY == 0) ? INT_MIN : nums2[partY-1];
            double r2 = (partY == n2) ? INT_MAX : nums2[partY];
            
            // check if we have found the correct partition
            if (l1 <= r2 && l2 <= r1){

                // if there even no of elements, we return the average of the max of the left side and min of the right side
                if ((n1+n2) % 2 == 0) {
                    return ( (max(l1,l2) + min(r1,r2) )/ 2 );
                }
                // if there are odd no of elements, we return the max of the left side
                else{
                    return min(r1, r2);
                }
            }
            // if l1 is greater than r2, it means we need to move the partition in nums1 to the left
            // this is because we need to ensure that the left side of nums1 is less than or equal to the right side of nums2
            else if (l1 > r2){
                high = partX;
            }

            // we need to move the partition in nums1 to the right
            else{
                low = partX + 1;

            }
        }
        // dummy return statement to avoid compilation error
        return 0.0;
        
    }
};