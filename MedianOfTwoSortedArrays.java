/** 
 * Time Complexity : O(log n) where n is the size of the shorter array
 * Space Complexity : O(1) 
*/


public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0; int high = n1;
        while(low<=high){
            int partition1 = low+(high-low)/2;
            int partition2 = ((n1+n2+1)/2)-partition1;
            double l1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1-1];
            double r1 = (partition1 == n1) ? Integer.MAX_VALUE : nums1[partition1];
            double l2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2-1];
            double r2 = (partition2 == n2) ? Integer.MAX_VALUE : nums2[partition2];
            
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                     return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else{
                   return Math.max(l1,l2);
                }
            }
            else if(l2>r1)
                low = partition1+1;
            else
                high = partition1-1;
        }
        return -1;
    }
}