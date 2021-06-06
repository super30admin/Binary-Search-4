public class FindTheMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums2);

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionOne = low + (high - low) / 2;
            int partitionTwo = ((n+m)/2) - partitionOne;
            int l1 = partitionOne == 0 ? Integer.MIN_VALUE: nums1[partitionOne - 1]  ;
            int r1 = partitionOne == m ? Integer.MAX_VALUE: nums1[partitionOne];
            int l2 = partitionTwo == 0 ? Integer.MIN_VALUE: nums2[partitionTwo - 1];
            int r2 = partitionTwo == n ? Integer.MAX_VALUE: nums2[partitionTwo];

            if(l2 < r1 && l1 < r2) {
                if((m+n)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                } else {
                    return r2;
                }
            } else if (l2> r1) {
                low = partitionOne + 1;
            } else {
                high = partitionOne - 1;
            }
        }

        return 1.0;

    }

    public static void main(String[] args) {
        FindTheMedian findTheMedian = new FindTheMedian();
        double median = findTheMedian.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 });
        System.out.println("The Median is" + median);
    }
}
