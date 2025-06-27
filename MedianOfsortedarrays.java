// Time complexity - O(logn)
// Space complexity - O(1)
// Initially identify the partition based on the binary search. when we get part1, calculate part2 with the formula of (m+n)/2 and then check if the 2 partitions are the final results by comparing the values of x1,x2,y1,y2. the main aim here is all the elements on left must be less than right
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n>m) {
           return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0, high = n;
        while(low<=high) {
            int part1 = low + (high-low)/2;
            int part2 = (n+m+1)/2 - part1;

            int x1 = (part1 == 0 ) ? Integer.MIN_VALUE : nums1[part1-1];
            int y1 = (part1 == n) ? Integer.MAX_VALUE : nums1[part1];
            int x2 = (part2 == 0 ) ? Integer.MIN_VALUE : nums2[part2-1];
            int y2 = (part2 == m) ? Integer.MAX_VALUE : nums2[part2];
            if(x1<=y2 && x2<=y1) {
            if((m+n)%2 ==0) {
                return (double) ((Math.max(x1,x2) + Math.min(y1, y2))/2.0);
            } else {
               return (double) (Math.max(x1, x2));
            }
                    } else if(x1 > y2) {
            high = part1 - 1;
        } else {
            low = part1 + 1;
        }
        }
        return 0;
    }
}
