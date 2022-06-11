//Time: O(Log(Min(M, N)) | Space: O(1)

//Binary search soln
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(n < m) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = m;
        while(low <= high) {
            int partX = low+(high-low)/2; // we create a partition on smaller array
            int partY = ((m+n)/2) - partX; // we create a parition on larger upon partX with respect to the median pos
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];
            // we apply binary Search on the smaller array
            // make paritions on larger in constant time
            if(l1<= r2 && l2 <= r1) {
                if((m+n)%2 == 0)  {
                    return (Math.max(l1, l2)+Math.min(r1,r2))/2;
                }
                return Math.min(r1, r2);
            } else if(l1 > r2) high = partX-1;
            else low = partX+1;

        }
        return 9.00;
    }
}