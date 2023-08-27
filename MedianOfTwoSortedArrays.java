//Time Complexity : O(len1 * log(len1)) where len1 is the length of the shorter array
// Space Complexity : O(1) no auxiliary space is used
// Did this code successfully run on Leetcode :yes
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0 && len2 == 0){
            return 0.0;
        }

        if(len1 > len2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0; int high = len1; //binary search on the partitions and not on the elements itself
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (len1+len2)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX == len1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY == len2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1){
                //odd length
                if((len1+len2) % 2 != 0){
                    return Math.min(r1, r2);
                }else{
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                }
            }else{
                if(l2 > r1){
                    low = partX +1;
                }else{
                    high = partX -1;
                }
            }
        }
        return 1212.12;
    }
}
