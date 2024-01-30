//T.C O(log min(n1,n2))
//S.C O(1)
//Executed in Leetcode: yes

/*
Use binary search to find the correct partition in the given arrays
 */
class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int low =0, high = n1;

        while(low <= high){
            int partX = low + (high - low)/2; //mid of binary search
            int partY = (n1+n2)/2 - partX;

            double L1 = partX == 0? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n1? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == n2? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2 == 0)
                    return (Math.max(L1,L2)+ Math.min(R1,R2))/2;
                else
                    return Math.min(R1, R2);
            }else if(L1>R2)
                high = partX -1;
            else
                low = partX + 1;
        }

        return -1;
    }
}