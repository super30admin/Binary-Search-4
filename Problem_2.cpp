/**
 * Time Complexity:
 * The time complexity will be O(log(min(m,n)) where n and m are the lengths of array
 * 
 */

/**
 * Space Complexity:
 * The space complexity will be O(1).
 * 
 */



/**
 * Approach:
 * In order to find the median of the array we can first merge the 
 * two arrays and then sort them and then find the median.
 * This approach would have resulted in O((m+n)log(m+n)) where m and
 * n are the lengths of the two arrays.
 * 
 * To further optimize the solution we divide the arrays in partitions.
 * The number of partitons is equal to the length of the array starting from 0.
 * Now we divide the shorter and the longer in such a way that we have equal elements
 * on both side when we join the left sides of the two arrays and the right side of the two arrays.
 * To decide where to divide the shorter array we take the mid. Then we divide the
 * second array at (n1+n2)/2 - mid. 
 * 
 * Now we have to check if the last element in L! is lesser than the first element
 * in R2 and the last element in the L2 is lesser than the first element of R1. If it is ture
 * then we have to check the total number of elements are even or not. If they are even
 * our median will be max(L1,L2) + min(R1,R2))/2, otherwise it will be min(R1,R2).
 * 
 * Now if the given condition was not true, then one of the condition failed. If L1>R2,
 * it means we have to reduce the values in L1 so high will move to mid-1. Otherwise we have
 * to move low to mid +1.
 * 
 */

//The code ran perfectly on leetcode.







class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        int n1= nums1.size(), n2 = nums2.size();
        if(n1 == 0 && n2 == 0) return 0.0;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int low =0; 
        int high = n1;
        while(low<=high){
            int part1 = low + (high- low)/2;
            int part2 = (n1+n2)/2 - part1;
            double L1 = part1 == 0 ? INT_MIN : nums1[part1 - 1];
            double R1 = part1 == n1 ? INT_MAX : nums1[part1];
            double L2 = part2 == 0 ? INT_MIN : nums2[part2 - 1];
            double R2 = part2 == n2 ? INT_MAX : nums2[part2];
            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2) %2 == 0){
                    return (max(L1,L2) + min(R1,R2))/2;
                } else {
                    return min(R1,R2);
                }
                
            } else if (L1 > R2){
                high = part1 - 1;
            } else {
                low = part1 + 1;
            }
        }
        return 1.0000;  
    }
};