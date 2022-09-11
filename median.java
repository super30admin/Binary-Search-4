//Time - log(n)
//space - O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)
            return findMedianSortedArrays(nums2,nums1);
        
         int low = 0;
         int high = nums1.length;
         while(low<=high){
            int mid = low+(high-low)/2;
            int partition = (m+n)/2 - mid;
            double l1 = mid==0 ? Integer.MIN_VALUE : nums1[mid-1];
            double r1 = mid==m ? Integer.MAX_VALUE : nums1[mid];
            double l2 = partition==0 ? Integer.MIN_VALUE : nums2[partition-1];
            double r2 = partition==n ? Integer.MAX_VALUE : nums2[partition];
             
            if(l1<=r2 && l2<=r1){
                if((m+n) % 2 != 0){
                    return Math.min(r1,r2);
                }
                else{
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
            }
            else if(l1>r2){
                high = mid-1;
            }
            else
                low=mid+1;
        }
        return -1;
    }
}
