//Time Complexity - O(log m) - we only perform binary search on the array of smaller length. 
//Space Complexity - O(1)
//We use binary search using a partition based approach


//Other approaches 
// Two pointer - TC - O(M + N) SC - O(M + N) - storing it in an array
//Brute force - merge the two sorted arrays and then sort. Find median
// TC - (m + n) log (m + n)
//SC - O(m + n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return -1.0;
        }
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2,nums1);
        }
        //smaller array is taken as first partX and perform binary search on it. 
        int low = 0; 
        int high = m;
        while(low <= high){
            int part_X = low + (high - low) / 2;
            int part_Y = (m + n)/2 - part_X;
            double l1 = part_X == 0 ? Integer.MIN_VALUE : nums1[part_X - 1];
            double r1 = part_X == m ? Integer.MAX_VALUE : nums1[part_X];
            double l2 = part_Y == 0 ? Integer.MIN_VALUE : nums2[part_Y - 1];
            double r2 = part_Y == m ? Integer.MAX_VALUE : nums2[part_Y];
            if(l2 <= r1 && l1 <= r2){
                //even number of elements total
                if((m + n) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }
                else{
                    return Math.min(r1,r2);
                }

            }
            else if(l1 > r2){
                high = part_X - 1;

            }
            else if(l2 > r1){
                low = part_X + 1;

            }

        }
        return 563.76;
    }
}