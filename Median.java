package Binary-Search-4;

public class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        //binary search on less element array nums1
        int low = 0;int high = n1;
        while(low<=high){
            int partX = low + (high -low)/2;
            int partY = (n1+n2)/2 - partX;
            // L1 L2 R1 R2
           int L1 = partX == 0 ? Integer.MIN_VALUE: nums1[partX-1];
           int L2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY-1];
           int R1 = partX == n1 ? Integer.MAX_VALUE: nums1[partX];
           int R2 = partY == n2 ? Integer.MAX_VALUE: nums2[partY];

           if(L1 <= R2 && L2 <= R1){
            if((n1+n2)%2 == 0){
                //even
                return (Math.min(R1, R2)+ Math.max(L1, L2))/2.0; 
            }else{
                //odd
                return Math.min(R1, R2);
            }

           }else if(L1>R2){
            high = partX-1;
           }else{
            low = partX+1;
           }
        }

        return 0.0;
    }
}
