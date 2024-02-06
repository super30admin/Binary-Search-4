class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2,nums1);

        int low=0;
        int high= n1;
        int n=n1+n2;
        while(low<=high){
            int mid1= low+(high-low)/2;
            int mid2 = ((n1 + n2) / 2) - mid1;    

            int l1=mid1==0 ? Integer.MIN_VALUE:nums1[mid1-1];
            int l2=mid2==0 ? Integer.MIN_VALUE:nums2[mid2-1];
            int r1=mid1==n1 ? Integer.MAX_VALUE:nums1[mid1];
            int r2=mid2==n2 ? Integer.MAX_VALUE:nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if(n%2==1){
                    return Math.min(r1,r2);
                    
                }
                else{
                    return ((double)(Math.max(l1,l2)+ Math.min(r1,r2)))/2.0;
                }
            }else if(l2>r1){
                low=mid1+1;
            }
            else{
                high=mid1-1;
            }

        }
        return 45465465;
    }
}