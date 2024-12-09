//4. Median of Two Arrays: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
//Time Complexity: (m+n) log(m+n)
//Space Complexity: 0(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        //traverse over smaller int[]
        if(n1 > n2){
            findMedianSortedArrays(nums2, nums1);
        }
        //Binary Search
        int low = 0; int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (1 + n1 + n2)/2 - partX;
            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1] ;
            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1] ;
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            //correct partitions
            if(l1 <= r2 && l2 <= r1){
                //even number of elements
                if((n1+n2) % 2 == 0){
                    return (double)(Math.min(r1, r2) + Math.max(l1, l2))/2;
                    //odd number of elements
                }else {
                    return (double)Math.max(l1, l2);
                }
                //incorrect partitions
            } else if(l2 > r1){
                low = partX+1;
            } else {
                high = partX-1;
            }
        }
        return -1;
    }
}