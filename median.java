class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n)return findMedianSortedArrays(nums2,nums1);
        int l=0,h=m;
        while(l<=h){
            int par1=l+(h-l)/2;
            int par2=(m+n)/2-par1;
            double L1 = par1 == 0 ? Integer.MIN_VALUE : nums1[par1-1];
            double R1 = par1 == m ? Integer.MAX_VALUE : nums1[par1];
            double L2 = par2== 0 ? Integer.MIN_VALUE : nums2[par2-1];
            double R2 = par2 == n ? Integer.MAX_VALUE : nums2[par2];
             if(L1 <= R2 && L2 <= R1){
                //even case
                if((m+n)%2 == 0){
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                }else{
                    return Math.min(R1,R2);
                }

            }else if(L1 > R2){
                h = par1;
            }else{
                l = par1 + 1;
            }
 
        }

        return -1;

        }
    }