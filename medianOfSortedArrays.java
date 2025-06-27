//partition the two arrays such that all elements on left are less that all elements on the right. Then check if number of elements are odd or even and find median. PartX always on smaller array
//Time complexity: O(log(min(m,n)))
//Space complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while(low <= high) {
            int partX = low + (high - low)/2;
            int partY = (n1 + n2) / 2 - partX;
            double x1 = partX == 0 ? Double.NEGATIVE_INFINITY : nums1[partX - 1];
            double y1 = partX == n1 ? Double.POSITIVE_INFINITY : nums1[partX];
            double x2 = partY == 0 ? Double.NEGATIVE_INFINITY : nums2[partY - 1];
            double y2 = partY == n2 ? Double.POSITIVE_INFINITY : nums2[partY];
        
        if(x1 <= y2 && x2 <= y1) {      //correct partition
            if((n1 + n2) % 2 == 0) {    //odd numbers
                return (Math.min(y1,y2) + Math.max(x1,x2))/2;
            } else {                    //even numbers
                return Math.min(y1,y2);
            }
        } else if(x1 > x2) {            //wrong partition
            high = partX - 1;
        } else {
            low = partX + 1;
        }
        }
        return 4.00;
    }
}