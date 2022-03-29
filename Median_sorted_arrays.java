//Time complexity:min(logm, logn) Binary search applied only on one array
//SPace complexity:-o(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0;int high = n1;
        while(low <= high)
        {
            int partx = low+(high- low)/2;
            int party = n1+n2/2 - partx;
            double l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
            double R1 = partx == n1 ? Integer.MAX_VALUE :nums1[partx ];
            double l2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            double R2 = party == n2? Integer.MAX_VALUE : nums2[party];
            if(l1<= R2 && l2<= R1)
            {
                if((n1+n2 )%2 == 0)
                {
                    return (Math.max(l1,l2)+ Math.min(R1,R2))/2; 
                }
                else{
                    return Math.min(R1,R2);
                }
            }
            
            if(l1> R2)
            {
                high = partx -1;
            }
            else 
            {
                low = partx + 1;
            }
            
        }
        return 1.00;
        
        
    }
}
