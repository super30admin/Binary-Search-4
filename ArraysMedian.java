public class ArraysMedian {
    // TC is O(log(m))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);
        
        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        while(low<=high){
            int xp = (low+high)/2;
            int yp = (n1+n2+1)/2-xp;
            int l1 = xp > 0 ? nums1[xp-1]: Integer.MIN_VALUE;
            int l2 = yp > 0 ? nums2[yp-1]: Integer.MIN_VALUE;
            int r1 = xp == n1 ? Integer.MAX_VALUE : nums1[xp];
            int r2 = yp == n2 ? Integer.MAX_VALUE : nums2[yp];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1 > r2){
                high = xp-1;
            }else low = xp+1;
        }
        return 9;
    }
}
