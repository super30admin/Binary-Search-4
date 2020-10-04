// Time Complexity : O(logn) as we are travelling using binary search approach
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        // find sizes n1,n2
        // check for the smaller array
        // binary search on smaller array
        // calculate partitions
        // check conditions for l1, l2, r1, r2
        // move on respective sides...
        
        
        
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1); // flipping the matricies.
        }
        
        // binary search
        
        int low = 0;
        int high = n1;
        
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            
            int p_X = mid;
            int p_Y = (n1 + n2 +1)/2 - p_X; // finding partitions
            
                  
            double l1 = (p_X == 0) ? INT_MIN : nums1[p_X-1];
        
            double r1 = p_X == n1 ? INT_MAX:nums1[p_X];
            
            
             double l2 = (p_Y == 0) ? INT_MIN:nums2[p_Y-1];
            
            double r2 = p_Y == n2? INT_MAX:nums2[p_Y];
            
     
            
            // checking conditions
            
            if(l1<= r2 && l2<= r1){
                if((n1 + n2)%2 == 0)
                    return (max(l1,l2) + min(r1,r2))/2;
                else 
                    return max(l1,l2);
            }else if(l2>r1){
                low = mid +1;
                
            }else{
                high = mid -1;
            }
            
            
            
            
            
        }
        return -1;
    }
};