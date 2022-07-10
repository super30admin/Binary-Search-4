class Solution {
    //Time complexity: O(log(m+n))
    //Space complexity: O(1)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        if(m==0 && n==0)
            return 0.0;
        if(m>n)
            return findMedianSortedArrays(nums2,nums1);
        int l=0,h=m;
        while(l<=h){
            int px=l+(h-l)/2;
            int py=(m+n)/2-px;
            double l1=px==0 ? Integer.MIN_VALUE:nums1[px-1];
            double l2=py==0 ? Integer.MIN_VALUE:nums2[py-1];
            double r1=px==m ? Integer.MAX_VALUE:nums1[px];
            double r2=py==n ? Integer.MAX_VALUE:nums2[py];
            if(l1<=r2 && l2<=r1){
                if((m+n)%2==0){
                    return (Math.min(r1,r2)+Math.max(l1,l2))/2;
                }
                else{
                    return Math.min(r1,r2);
                }
            }
            else if(l2>r1){
                l=px+1;
            }
            else{
                h=px-1;
            }
        }
        return 0.0;
    }    
}