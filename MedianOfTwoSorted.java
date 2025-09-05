// This solution uses a binary search in finding the right partitions that divides both arrays such that left of each partition index elements on both arrays is less than or equal to all the elements on the right side of partitions.
// It uses the logic that if we choose one partition on first array, then the second array will have partition at size-x as the total elements should be equal on both sides
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = nums1.length;
        int k = 0, l = nums2.length;
        int size = ((nums1.length+nums2.length))/2;
        while(i<=j) {
            int part1 = i+(j-i)/2;
            int part2 = size-part1;

            int L1 = part1>0?nums1[part1-1]:Integer.MIN_VALUE;
            int R1 = part1!=nums1.length?nums1[part1]:Integer.MAX_VALUE;
            int L2 = part2>0?nums2[part2-1]:Integer.MIN_VALUE;
            int R2 = part2!=nums2.length?nums2[part2]:Integer.MAX_VALUE;

            if(L1<=R2 && L2<=R1) {
                if((nums1.length+nums2.length)%2==0) {
                    int a = Math.max(L1,L2);
                    int b = Math.min(R1,R2);
                    return (double)(a+b)/2.0;
                } else {
                    return (double)Math.min(R1,R2);
                }
            } else if(L1>R2) {
                j=part1-1;
            } else {
                i=part1+1;
            }
        }
        return -1;
    }
}
