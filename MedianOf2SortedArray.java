class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n < m){  //checking which array is larger to do BS on that to save on Time
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = m;    //we are not doing -1 because we are doing a BS on partition and not on the. elements
        while(low <= high){
            int partX = low + (high-low) / 2;   //making partition at mid of 1st array
            int partY = (m+n) / 2 - partX;  //calculating total elements and suubtracting the elements taken in 1st array and creating.a partitio in 2nd array
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1]; //placing l1 as the last element in the partition. If no elements are in partition the initializing it as -infinity
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1]; //doing the same for array 2
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];//declaring r1 as the 1st element of the right partition. If there are no elements then initializing it as + infinity
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];//doing same for 1st element in right partition for nums2
            if(l1 <= r2 && l2 <= r1){   //checking the conditions
                if((m + n) % 2  != 0){
                    return Math.min(r1,r2); //returning if the above condition are true if the total length is odd
                }
                else{
                    return (Math.max(l1,l2) + Math.min(r1, r2)) / 2.0;//if it's even, we do this
                }
            }
            else if(l2 > r1){
                low = partX + 1;
            }
            else{
                high = partX - 1;
            }
        }
        return 12345.2;
    }
}