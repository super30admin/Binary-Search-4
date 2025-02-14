// TC : O(log(min(m,n)))
// SC : O(1)

public class LC4 {
    private double getMedian(int small[], int large[]){
        int m = small.length;
        int n = large.length;
        int tot = m + n;
        int left = (1+tot)/2;
        int low = -1;
        int high = m-1;

        while(low<=high){
            int mid1 = (high + low) / 2;
            int mid2 = left - mid1 - 2;

            double l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            double r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1>=0) l1 = small[mid1];
            if(mid2>=0) l2 = large[mid2];
            if(mid1<m-1) r1 = small[mid1+1];
            if(mid2<n-1) r2 = large[mid2+1];

            if(l1<=r2 && l2<=r1){
                return ((tot%2)==0) ? (Math.max(l1, l2) + Math.min(r1, r2))/2.0 : Math.max(l1, l2);
            } else if(l1>r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) return findMedianSortedArrays(nums2, nums1);
        return getMedian(nums1, nums2);
    }
}
