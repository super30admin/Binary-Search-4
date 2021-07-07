// Time Complexity :O(log(min(n,m))) where n & m are the length of each arrays.
// Space Complexity :O(1) no additional space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Approach
// Get the window of median size choose the window in First Array and Second Array.
// Always do binary search on sorter array.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2== null)
            return 0.0;
        
        int lenNums1 = nums1.length;
        int lenNums2 = nums2.length;
        
        //Always making sure that minumum number is the first array.
        if(lenNums1 > lenNums2){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int size = lenNums1 + lenNums2;
        int medianSize = (size + 1)/2;  // For both odd and even number (total size + 1)/2 will give the exact middle element
        
        int maxLeftNums1; int maxLeftNums2; int minRightNums1; int minRightNums2;
        int low = 0;
        int high = lenNums1;
        while(low <= high){
            int partitionNums1 = (low + high)/2; // calculate middle element in first array
            int partitionNums2 = medianSize - partitionNums1; // choose rest of values till median size in second array
            //Boundary conditions for the partitions 
            //Nums1 left Window
            if(partitionNums1 == 0){
                maxLeftNums1 = Integer.MIN_VALUE;
            }else{
                maxLeftNums1 = nums1[partitionNums1-1];
            }
            //Nums1 Right Window
            if(partitionNums1 == lenNums1){
                minRightNums1 = Integer.MAX_VALUE;
            }else{
                minRightNums1 = nums1[partitionNums1];
            }
            
            //Nums2 left Window
            if(partitionNums2 == 0){
                maxLeftNums2 = Integer.MIN_VALUE;
            }else{
                maxLeftNums2 = nums2[partitionNums2-1];
            }
            
            //Nums2 Right Window
            if(partitionNums2 == lenNums2){
                minRightNums2 = Integer.MAX_VALUE;
            }else{
                minRightNums2 = nums2[partitionNums2];
            }
            
            // Main Condition to be satisfied
            if(maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1){
               
                if(size%2==0){ // In case of even number of values return avg of middle 2 numbers
                    return (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2))/2.0;
                }else{ // In case of odd number of values return max of left values.
                    return Math.max(maxLeftNums1, maxLeftNums2);   
                }
                
            }else if(maxLeftNums1 > minRightNums2){ //Adjust if left side has higher numbers
                high = partitionNums1-1;
            }else{
                low = partitionNums1+1; //Adjust if right side has higher numbers
            }
            
        }
        return 0.0;
    }
}
