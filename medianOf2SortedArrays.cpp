/*
Intuition: We need to create partiions such that there are equal number of elements on the left and right of paritition
#####################################################################
Solution: 
Time Complexity : O(log(min(m,n))) where m = size of array 1, n= size of array 2
Space Complexity : O(1)

*/
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        if ( nums1.size() > nums2.size()){ 
            return helper(nums2, nums1);
        }
        return helper(nums1, nums2);
        
    }
    double helper(vector<int>& nums1, vector<int>& nums2){
        int n1 = nums1.size();
        int n2 = nums2.size();
        int low = 0;
        int high = n1;
        while ( low <= high) {
            int partX = low + (high-low) /2;
            int partY = ((n1+ n2)/2) - partX;
            double L1 = (partX == 0) ? INT_MIN : nums1[partX-1];
            double L2 = (partY == 0) ? INT_MIN : nums2[partY-1];
            double R1 = (partX == n1 ) ? INT_MAX : nums1[partX];
            double R2 = (partY == n2) ? INT_MAX : nums2[partY];
            
            if ( L1 <= R2 and L2 <= R1){
                if ( (n1+ n2) % 2 ==0){
                    return (max(L1, L2)+ min(R1, R2))/2;
                }
                else{
                    return (min(R1, R2));
                }
            }
            else if( L2 > R1 ) low = partX +1;
            else high = partX -1;
            
        }
        return -500.0;
    }
};