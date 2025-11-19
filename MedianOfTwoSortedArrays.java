// Time Complexity : O(log n) where n is the length of smaller array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform Binary search on the partitions of the smaller sized array and consequently partition the other array as well. The
// goal is to make sure all the left side of the partiton elements are smaller than the right side partition ones. To achieve this we
// calculate left1,left2,right1,right2, compare them and move the search space appropriately until low<=high. Then based on the total
// length of two arrays being even or odd we calculate the median.


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int sum = n1+n2; //length of two arrays
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1); //to perform binary search on the smaller size array
        }
        int low = 0;
        int high = n1;

        while(low <= high){
            int partX = (low+high)/2; //partition X on the smaller array
            int partY = (n1+n2)/2 - partX; //partition Y on the other array

            double left1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1]; //left value of partition X
            double right1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];//right value of partition X
            double left2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];//left value of partition Y
            double right2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];//right value of partition Y

            if(left1 <= right2 && left2 <= right1){ //combined array is sorted
                if(sum % 2 == 0){ //if length is even, median calculation
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2;
                }else{
                    return Math.min(right1,right2); //if length is odd, median calculation
                }
            } else if(left1 > right2){ //shift the search space to left
                high = partX - 1;
            }else{
                low = partX + 1;//shift the search space to right
            }
        }

        return Integer.MIN_VALUE;
    }
}