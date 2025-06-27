//Time Complexity : O(log(N1))
//Space Complexity : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length; 
        int n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = n1;

        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            double X1 =   partX==0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double Y1 =   partX==n1 ? Integer.MAX_VALUE : nums1[partX];
            double X2 =  partY==0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double Y2 = partY==n2 ? Integer.MAX_VALUE : nums2[partY];

            if(X1 <= Y2 && X2 <=Y1){
                if((n1+n2)%2 == 0){
                    return(Math.min(Y1,Y2) + Math.max(X1,X2))/2;
            } else {
                return Math.min(Y1,Y2);
            }
        } else if(X1 > Y2){
            high = partX -1;
        } else {
            low = partX +1;
        }

        }
        return 4.00;
    }
}
