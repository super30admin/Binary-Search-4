public class Median{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2) 
            return findMedianSortedArrays(nums2,nums1);    //we want n1 to be smaller array always

        //Binary search for partition
        int low = 0, high = n1; //taking n1 and not n1-1 cause we want bs on partitions
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;
            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                //correct partition 
                if((n1 + n2) % 2 == 0){
                     //even length
                    return (double)(Math.max(L1, L2) + Math.min(R1,R2))/2;
                }else{
                    //odd length, cause the extra number is in the right side 
                    return Math.min(R1, R2);
                }
            }
            else if(L2 > R1){
                //move right 
                low = partX + 1;
            }else{
                high = partX - 1;
            }

        }

        return -1;
    }
}