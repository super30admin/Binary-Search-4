//Time complexity = O(log(min(m,n))) , as we do binary search on smaller array
//Space complexity  = O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);

        }
        int low = 0;
        int high  = m;
        
        //we will do binary search on smaller array
        while(low <= high){
            int partitionofx = low + (high - low) /2;
            int partitionofy = (m+n+1)/2 - partitionofx; //If total length is odd, the left half has one more element.
            //x1,x2,y1,y2
            double x1,x2,y1,y2;
            if(partitionofx == 0){
                x1 = Integer.MIN_VALUE;
            }
            else{
                x1 = nums1[partitionofx-1];
            }
            if(partitionofx == m){
                y1 = Integer.MAX_VALUE;
            }
            else{
                y1 = nums1[partitionofx];
            }
            if(partitionofy == 0){
                x2 = Integer.MIN_VALUE;
            }
            else{
                x2 = nums2[partitionofy-1];
            }
            if(partitionofy == n){
                y2 = Integer.MAX_VALUE;
            }
            else{
                y2 = nums2[partitionofy];
            }
            //if u get correct partition , find median
            if(x1 <= y2 && x2<=y1){ //means crct partition
               if((m+n)%2 == 0){//if m+n is even
                return (Math.max(x1,x2) + Math.min(y1,y2))/2;
                }
                else{ //if m+n is odd
                  return Math.max(x1,x2);
                }
            }
            else if (x1 > y2) {
                high = partitionofx - 1;
            } 
            else if (x2 > y1) {
                low = partitionofx + 1;
            }
        }
        return 0.0;
        
    }

}