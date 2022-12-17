// Approach 1: 2 pointers 
// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 

// Apprach 2: Binary search 
// Time Complexity : O(log m) where m is the size of the smaller array 
// Space Complexity : O(1)

// Approach 1: 2 Pointers 

// Have 2 pointers which keeps moving to get the 'median' numbers 

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size()==0 && nums2.size()==0) return 0.0;
        double result;
        int i = 0, j = 0, k=0;
        int m = nums1.size();
        int n = nums2.size();
        int isEven = 0, median;
        if((m+n)%2 == 0){
            median = (m+n)/2;
            isEven = 1;
        }
        else 
            median = (m+n+1)/2;

        while(k < median && i < m && j < n){
            if(nums1[i] < nums2[j])
                result = nums1[i++];
            else 
                result = nums2[j++];
            k++;
        }

        // if there are still elements left in the 
        while(k < median && i<m){
            result = nums1[i++];
            k++;
        }

        while(k < median && j<n){
            result = nums2[j++];
            k++;
        }

        if(isEven == 0)
            return result;

        // The elements are present in both arrays and we get the smaller of the pointers 
        if(i<m && j<n) {
            return (result+min(nums1[i], nums2[j]))/2;
        }

        // both numbers lie in nums2 
        if(i==m && j<n) {
            return (result+nums2[j])/2;
        }

        // both numbers lie in nums1
        return (result+nums1[i])/2;
    }
};


// Approach 2: Binary Search 

/*
Binary search the smaller array to get the partition of the array 
Based on that partition, we know how many more elements we need from array 2 to fill all the median numbers 

Get the boundary numbers next to the partitions and once the partition is correct, return the result 

Partitoin is correct when the following is true:
1. l1 <= l2 -> this is always true 
2. r1 <= r2 -> this is always true 
3. l1 <= r2
4. l2 <= r1

if odd: just return the min of r1 and r2 
if even -> average of max(l1,l2) and min(r1,r2)

Ex: 1 2 4 6 | 9
          5 | 7 8 10

If the partition is not correct, re-calculate the partition using BS and recheck the condition

*/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0 && nums2.size() == 0) return 0;

        int m = nums1.size();
        int n = nums2.size();

        // median is added 1 such the the numbers to the right of the partition will have the solution 
        int median = (m+n+1)/2;

        //Lets consider nums1 to be the smaller array and nums2 to be the larger array 

        if(m > n)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = m;

        // partition the first array and check if the point where the array is partitoined is correct 
        // the numbers on the left shuold be less than the numbers on the right 

        // Ex: 1 2 4 6 | 9
        //           5 | 7 8 10

        // result = min of the last elements on the left of the partition
        // if total is even, we take the average of the max on left and min on right 
        while(low <= high){
            // calculate the mid aka partition of X
            int partX = low + (high-low)/2;
            // partition of Y would be the remianing numbers required to fill the median 
            int partY = median - partX;

            // Get the 4 numbers at the partition or +∞ on the right and -∞ on the left
            int l1 = (partX == 0)? INT_MIN : nums1[partX-1];
            int l2 = (partY == 0)? INT_MIN : nums2[partY-1]; 
            int r1 = (partX == m)? INT_MAX : nums1[partX];
            int r2 = (partY == n)? INT_MAX : nums2[partY];

            // if the partition is correctly made, return the result
            if(l1 < r2 && l2 < r1) {
                if ((m+n)%2 != 0){
                    return max(l1,l2);
                }
                else {
                    return (max(l1,l2) + min(r1,r2))/2.0;
                }
            }

            // l1 is bigger which means the partition at X needs to go left towards smaller numbers 
            if(l1 > r2)
                high = partX - 1;

            else
                low = partX + 1;
        }
        return 0;
    }
};