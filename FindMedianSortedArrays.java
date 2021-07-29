// Time Complexity : O(log n)
// Space Complexity : O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int l = 0;
        int h = n1;
        while(l <= h){
            int p1 = l + (h - l) / 2;
            int p2 = (n1 + n2) / 2 - p1;
            double x1 = p1 == 0? Integer.MIN_VALUE: nums1[p1 - 1];
            double y1 = p1 == n1? Integer.MAX_VALUE: nums1[p1];
            double x2 = p2 == 0? Integer.MIN_VALUE: nums2[p2 - 1];
            double y2 = p2 == n2? Integer.MAX_VALUE: nums2[p2];
            if(x1 <= y2 && x2 <= y1){
                if((n1 + n2) % 2 == 0)
                    return (Math.max(x1, x2) + Math.min(y1, y2)) / 2;
                else
                    return Math.min(y1, y2);
            }
            else if(x2 > y1)
                l = p1 + 1;
            else
                h = p1 - 1;
                
        }
        return -1;
    }
}