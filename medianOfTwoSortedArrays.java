    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/median-of-two-sorted-arrays/
    Time Complexity for operators : o(log(min(m,n)) .. m and n are leangth of two different arrays
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Check the length of Array if nums1 is bigger then swap the arrays.
                    B) Then, Do the binary search on the smaller array
                    C) First we will claculate the va;od parts L1, R1, L2, R2
                    D) check l1 <= r2 && l2 <= r1 then return the values depeding upon odd or even  number of elements
                                if((n1+n2)%2 == 0){
                                    return (Math.max(L1,L2)+ Math.min(R1,R2))/2;
                                }else{
                                    return Math.max(L1, L2);
                                }
                    E) If L2 > R1 then mode left to the mid+1
                    F) Else, move right to the mid-1

    */  

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
          // 1) initialize sizes n1 and n2
        // 2) check which array is smaller
        // 3) do binary search on smaller array
        // 4) calculate parititions
        // 5) check l1 <= r2 && l2 <= r1 then voila
        // 5.1) check if odd or even and return accordingly
        // 6) check which side ot move on
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        
        // 1) initialize sizes n1 and n2
        // 2) check which array is smaller
        if(n1 > n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        // 3) do binary search on smaller array
        int low = 0;
        int high = n1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            // 4) calculate parititions
            int partX = mid;
            int partY = (n1+n2+1)/2 - partX;
            
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            // 5) check l1 <= r2 && l2 <= r1 then voila
            // 6)
            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2 == 0){
                    return (Math.max(L1,L2)+ Math.min(R1,R2))/2;
                }else{
                    return Math.max(L1, L2);
                }
            }else if(L2 > R1){
                low = mid + 1;
            }else{
                high = mid - 1; 
            }
        }
        return -1;
    }
}