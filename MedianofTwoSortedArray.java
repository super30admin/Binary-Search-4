
//TC: O(log(min(m,n))
//SC: O(1)
class MedianofTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null){
            return 0.0;
        }
        
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2, nums1);
        }

        int l=0;
        int r=m;
        while(l<=r){
            int partx=l+(r-l)/2;
            int party=(m+n)/2 - partx;
            int l1;
            if(partx==0){
                l1=Integer.MIN_VALUE;
            }else{
                l1=nums1[partx-1];
            }

            int l2;
            if(party==0){
                l2=Integer.MIN_VALUE;
            }else{
                l2=nums2[party-1];
            }

            int r1;
            if(partx==m){
                r1=Integer.MAX_VALUE;
            }else{
                r1=nums1[partx];
            }

            int r2;
            if(party==n){
                r2=Integer.MAX_VALUE;
            }else{
                r2=nums2[party];
            }

            if(l1<=r2 && l2<=r1){
                //correct partition
                if((m+n)%2==0){
                    return (Math.min(r1,r2)+Math.max(l1,l2))/2.0;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l1>r2){
                r=partx-1;
            }else{
                l=partx+1;
            }
        }
        return 11;
    }
}
