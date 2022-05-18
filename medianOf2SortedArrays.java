//TC : O(Log(m,n))
//SC : O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null) return 0.0;

        int n1= nums1.length;
        int n2= nums2.length;

        if(n1>n2)
            return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int high = n1;
        while(high>=low)
        91      05int partX = low+(high-low)/2;
            int partY = (n1+n2)/2 - partX;
            double l1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r1 = partX==n1 ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY==n2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2 !=0)
                    return Math.min(r1,r2);

                return (Math.min(r1,r2)+Math.max(l1,l2))/2.0;
            }
            else if(l1>r2)
            {
                high = partX-1;
            }
            else
                low = partX+1;
        }
        return 2.0;
    }
}