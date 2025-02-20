class Solution {
    //time complexity :O(log(m+n)
    //Space complexity: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

       if ( nums1.length > nums2.length)
       return findMedianSortedArrays(nums2, nums1);
       int req = (nums1.length + nums2.length)/2;

       // do a binary search on the firstArray and take out the mid
       int m = nums1.length;
       int n = nums2.length;
       int low =0;
       int high= m;

       while (low <= high ){
        int partx = low + (high -low)/2;
       int party = (m + n) / 2 - partx;
        double l1 = partx ==  0 ? Integer.MIN_VALUE : nums1[partx-1];
        double r1 = partx ==  m ? Integer.MAX_VALUE : nums1[partx];
        double l2 = party ==  0 ? Integer.MIN_VALUE : nums2[party-1];
        double r2 = party ==  n ? Integer.MAX_VALUE : nums2[party];

        if (l1 <= r2 && l2 <= r1){
            if ((m+n) % 2 != 0){
                return Math.min(r1,r2);
            }
            return (Math.max (l1,l2) + Math.min (r1,r2))/2.0;
        }
        else if (l2 > r1){
            low = partx+1;
        }
        else if (l1 > r2){
            high = partx -1;
        }
       }
       return 123;

    }
}
