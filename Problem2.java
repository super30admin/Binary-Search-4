//Time Complexity: O(log(min(m,n))
//Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length,n2 = nums2.length, n=n1+n2;
        int size = (n1 + n2)/2;
        int low = 0;
        int high = n1;

        int mid, complement;
        int w1, w2, w3, w4;
        while(true){
            mid = low + (high - low)/2;
            complement = size - mid;

            w1 = mid==0?Integer.MIN_VALUE:nums1[mid-1];
            w2 = mid==n1?Integer.MAX_VALUE:nums1[mid];
            w3 = complement==0?Integer.MIN_VALUE:nums2[complement-1];
            w4 = complement==n2?Integer.MAX_VALUE:nums2[complement];

            if(w1 <= w4 && w3 <= w2)
                return n%2==0?(Math.max(w1, w3) + Math.min(w2, w4))/2.0:Math.min(w2, w4);
            if(w1 > w4)
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
}