package week7.day4;
//TC - O(n1)
//SC - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2)
            return findMedianSortedArrays(nums2,nums1);  //we are swapping n1 and n2, to small size array at n1, so we do BS at n1

        int low =0;
        int high = n1;
        while(low<=high){
            int PartX = low + (high-low)/2;
            int PartY = (n1+n2)/2 - PartX;
           
            double L1 = (PartX==0) ? Integer.MIN_VALUE : nums1[PartX-1];
            double L2 = (PartY==0) ? Integer.MIN_VALUE : nums2[PartY-1];
            double R1 = (PartX>=n1) ? Integer.MAX_VALUE : nums1[PartX];
            double R2 = (PartY>=n2) ? Integer.MAX_VALUE : nums2[PartY];

            if(L1<=R2 && L2<=R1){
                //both the sides are sorted
                //even
                if((n1+n2)%2==0)
                    return (Math.max(L1, L2)+Math.min(R1, R2))/2;
                //odd
                else
                    return Math.min(R1, R2);
            }
            else if(L2>R1)
                low = PartX+1;
            else
                high = PartX-1;

        }
        return -1;
    }
}
public class MedianOfSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
