class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length==0  || nums1 == null && nums2 == null)
        {
            return 0.0;
        }
        int n1 = nums1.length;
        int n2=nums2.length;
        if(n2<n1)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high =nums1.length;
        while(low<=high)
        {
            int part_x=low+(high-low)/2;
            int part_y=((n1+n2)/2)-part_x;

            double l1=part_x==0 ? Integer.MIN_VALUE : nums1[part_x-1];
            double l2=part_y==0 ? Integer.MIN_VALUE : nums2[part_y-1];
            double r1=part_x==n1 ? Integer.MAX_VALUE : nums1[part_x];
            double r2=part_y==n2 ? Integer.MAX_VALUE : nums2[part_y];

            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2==0)
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2)) / 2;
                }
                return Math.min(r1,r2);
            }
            else if(l1>r2)
            {
                high=part_x-1;
            }
            else
            {
                low=part_x+1;
            }
        }
        return 0.0;
    }

}