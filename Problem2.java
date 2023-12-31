// Time Complexity : O(log(min(x,y))) where x and y are the lengths of the nums1 and nums2 arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] x;// smaller length array
        int[] y;// larger length array;

        if(nums1.length < nums2.length){
            x = nums1;
            y=nums2;
        }else{
            x=nums2;
            y=nums1;
        }

        int low =0;
        int high = (x.length+1) - 1; // remember that we are doing the binary search on the partitions not the array element, if you draw an array of 5 elements, then it will have arr.length+1 partitions |1|2|3|4|5| <----- Count the bars and you will know 
        boolean isEven = (x.length + y.length) % 2 == 0;
        // doing binary search on the smaller length array
        
        while(low<=high){
            int partX = low + (high-low)/2; // aka mid , partition index is not included on the left part
            int partY =(x.length + y.length)/2 - partX; // taking the index of part x , partition index is not included on the left part

            int l1 = (partX == 0) ? Integer.MIN_VALUE : x[partX-1]; // highest element of the lower x array
            int l2 = (partY== 0) ? Integer.MIN_VALUE : y[partY-1]; // highest element of the lower y array

            int r1 = (partX >= x.length) ? Integer.MAX_VALUE:x[partX];
            int r2 = (partY >= y.length) ? Integer.MAX_VALUE : y[partY];

            if(l1 <= r2 && l2 <= r1){
                if(isEven){
                    int max = Math.max(l1,l2);
                    int min = Math.min(r1,r2);
                    double res = (max+min)/2.0; // if the answer is on double, then all the values should be double, otherwise the result will be rounded off to Integer
                    return res;
                }
                else{
                    int min = Math.min(r1,r2);
                    return min;

                }
            } else if(l1 > r2 ){
                high = partX -1 ; // this means we need to find lower element on the x array
            }
            else{
                low = partX +1 ; // this means that we need to find lower element on the y array, which can only be possibly if low is moved on the right side on the x
            }
        }

        return -1.0; // this will never reach so 
    }
}