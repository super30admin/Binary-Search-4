class MedianSortedArrays {
    
    /*
      Time : O(log(Min(n,m))) : | n,m are lengths of nums1 and nums2
      Space : O(1) | not creating any new Data structure
      Leetcode : Yes
    */
    
    /*
      Approach
      1. Consider both arrays are sorted and merged so median will be middle item (odd length) else avg of middle
      2. Virtually partition both array in left and right ( So items in left half should be smaller than items in right half)
      3. start with binary serach on low length array, calculate mid, and keep all items lower to mid index as l1,
      4. for  arr2 : do (n1+n2)/2 - partX
      5. arr2 partition size depends on partX in arr1. 
      6. Now move pointers around to change the partition size,
      7. as we find l1 <= r2 && l2 <= r1 we found correct partition now calculate median and return.
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 < n1)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double l1 = partX == 0 ?  Integer.MIN_VALUE :  nums1[partX -1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                // find median
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }
            else if(l2 > r1){
                low = partX + 1;
                
            }else {
                high = partX - 1;
            }
            
           
        }
        return -1;
    }
}
