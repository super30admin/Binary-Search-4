// Time Complexity : O(Log(M+N))
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Partiton based Binary search
Maintain paritions, make sure left values are always small than right values in a valid partition
*/
public class MedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //binary search on nums1 --> nums1 is smaller
        //but if
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        double result=0;

        int m=nums1.length, n=nums2.length;
        int low=0, high=m,mid, p2;


        while(low<=high){
            //mid is partition 1
            mid=low+(high-low)/2;
            //partition 2
            p2 = (m+n)/2 - mid;

            double l1= mid==0 ? Integer.MIN_VALUE : nums1[mid-1];
            double r1= mid==m ? Integer.MAX_VALUE : nums1[mid];

            double l2= p2==0 ? Integer.MIN_VALUE : nums2[p2-1];
            double r2= p2==n ? Integer.MAX_VALUE : nums2[p2];

            if(l2>r1){
                low=mid+1;
            }else if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return  (Math.min(r1,r2)+
                            Math.max(l1,l2))/2.0;
                }else{
                    return Math.min(r1,r2);
                }
            }else {
                high=mid-1;
            }
        }


        return result;
    }
}
