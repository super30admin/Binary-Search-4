//Time Complexity=O(logn)
//Space Complexity=O(1)
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1=nums1.length;
        int n2=nums2.length;
        if(n1==0 && n2==0) return 0;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);


        int low=0,high=n1;

        while(low<=high){
            int px=low+(high-low)/2;
            int py=(n1+n2)/2-px;
            double l1=px==0?Integer.MIN_VALUE:nums1[px-1];
            double l2=py==0?Integer.MIN_VALUE:nums2[py-1];
            double r1=px==n1?Integer.MAX_VALUE:nums1[px];
            double r2=py==n2?Integer.MAX_VALUE:nums2[py];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l2>r1){
                low=px+1;
            }else{
                high=px-1;
            }
        }

        return 3.14;
    }
}
