
//Time: log(min(m, n)) where m=length of nums1 and n=length of nums2
//Space:O(1)
//Did it run successfully on leetcode: Yes
class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //getting length of input arrays
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        //initializing hogh ans low
        int low = 0, high = n1;
        //untile low is not greater than high
        while(low<=high){
            //get partition index of nums1 array
            int partX = low+(high-low)/2;
            //get partition index for nums2 array
            int partY = (n1+n2)/2-partX;
            //get closest variables to the left and right of both the partitions
            double l1 = partX==0 ? Integer.MIN_VALUE:nums1[partX-1];
            double l2 = partY==0 ? Integer.MIN_VALUE:nums2[partY-1];
            double r1 = partX==n1?Integer.MAX_VALUE:nums1[partX];
            double r2 = partY==n2 ? Integer.MAX_VALUE:nums2[partY];
            //if partition if fine
            if(l1<=r2 && l2<=r1){
                //if total elements combining both input array is even
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }//if total elements combining both input array is odd
                else{
                    return Math.min(r1,r2);
                }
            }
            //if closest element to the left of partition Y i.e. nums2 array
            // is greater than closest element to the right of partition X i.e. nums1 array
            else if(l2>r1){
                //move lower to the right;
                low = partX+1;
            }
            else {
                //move high pointer to the left
                high = partX-1;
            }
        }
        return 1.0;
    }
}