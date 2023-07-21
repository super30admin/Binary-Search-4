public class MedianOfTwoSortedArrays {
    //Time Complexity: O(LOG(M+N))
    //Space Complexity: Constant
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // we should start with the samller array
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int begin = 0;
        int end = nums1.length;

        while(begin <= end){
            int partitionA = (begin + end)/ 2;
            int partitionB = ((nums1.length + nums2.length) / 2) - partitionA;

            double maxLeftA = partitionA == 0? Integer.MIN_VALUE: nums1[partitionA - 1];
            double minRightA = partitionA == nums1.length? Integer.MAX_VALUE: nums1[partitionA];
            double maxLeftB = partitionB == 0? Integer.MIN_VALUE: nums2[partitionB - 1];
            double minRightB = partitionB == nums2.length? Integer.MAX_VALUE: nums2[partitionB];

            //if(left partition is < right partition) we have found the centre
            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                //odd length
                if((nums1.length + nums2.length) % 2 != 0){
                    return Math.min(minRightA,minRightB);
                }else{
                    //even length
                    return (Math.min(minRightA,minRightB)+ Math.max(maxLeftA,maxLeftB))/2;
                }
            }

            if(maxLeftA > minRightB){
                end = partitionA - 1;
            }else{
                begin = partitionA + 1;
            }

        }

        return 0.0;

    }

}
