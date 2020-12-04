
class Median_of_TwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        while(low <= high)
        {
            int xPart = low + (high - low) / 2;
            int yPart = (n1 + n2) / 2 - xPart;
            double l1 = xPart == 0 ? Integer.MIN_VALUE : nums1[xPart - 1];
            double r1 = xPart == n1 ? Integer.MAX_VALUE : nums1[xPart];
            double l2 = yPart == 0 ? Integer.MIN_VALUE : nums2[yPart - 1];
            double r2 = yPart == n2 ? Integer.MAX_VALUE : nums2[yPart];
            
            if(l1 <= r2 && l2 <= r1)
            {
                if((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                else
                    return (Math.min(r1, r2));
            }
            else if(l2 > r1)
            {
                low = xPart + 1;
            }
            else
            {
                high = xPart - 1;
            }
        }
        return 1.0;
    }
    public static void main(String[] args)
    {
    	int[] nums1 = {1,3,5,7};
    	int[] nums2 = {2,6,8,10,12,14,16};
    	Median_of_TwoSortedArrays_4 median = new Median_of_TwoSortedArrays_4();
    	System.out.println(median.findMedianSortedArrays(nums1, nums2));
    }
}