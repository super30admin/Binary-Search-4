// Time Complexity : O(log(min(n1,n2)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Approach:
 1. Binary search on the smaller array to choose a partition
 2. Set the partition on the other array using the first array partition index
 3. Compare the left and right elements close to the partitions to validate the partitions.
 4. For even no of elements return the average of the two closest left and right
 5. For odd number of elements, retun the closest value from the partition with one extra value(here right partition)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        int n1=nums1.length;
        int n2=nums2.length;

        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low=0, high=n1; //for partitions we include boundaries

        while(low<=high){

            int partX=low+(high-low)/2;
            int partY=(n1+n2)/2-partX;

            double L1=(partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            double L2=(partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            double R1=(partX==n1)?Integer.MAX_VALUE:nums1[partX];
            double R2=(partY==n2)?Integer.MAX_VALUE:nums2[partY];

            if(L1<=R2 && L2<=R1){
                //correct partitions
                if((n1+n2)%2==0){ //even length of arrays
                    return ((Math.max(L1,L2) + Math.min(R1,R2))/2);
                }
                else{ //total array length is odd
                    return Math.min(R1,R2);
                }
            }
            else if(L1>R2){
                high=partX-1;
            }
            else {
                low=partX+1;
            }
        }
        return -1;
    }
}