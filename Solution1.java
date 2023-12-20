//Median of 2 sorted array
//TC: log(n1)//BS on smaller array 
class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //null chk by default
        if(nums1.length==0 && nums2.length==0)
        {
            return 0.0;
        }
        int n1=nums1.length;
        int n2=nums2.length;
        //make sure that first array contains less elements
        if(n1>n2)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        //perform BS on first array only
        int low=0;
        int high=n1;
        while(low<=high)
        {
            //we take partX at the mid of the array
            int partX=low+(high-low)/2;
            //out of total, half - partX will give partY
            int partY=(n1+n1)/2-partX;
            //check for extreme conditions only
            double L1 = partX == 0 ? Integer.MIN_VALUE:nums1[partX-1];
            double R1 = partX == n1 ? Integer.MAX_VALUE:nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE:nums2[partY-1];
            double R2 = partY == n2 ? Integer.MAX_VALUE:nums2[partY];

            //check for even and odd , we got L1,R1,L2 and R2 now
            if(L1<=R2 && L2<=R1)
            {
                if((n1+n2)%2!=0)
                {
                    //middle element in a median of array
                    return Math.min(R1,R2);
                }
                else
                {
                    return (Math.min(R1,R2)+Math.max(L1,L2))/2;
                }
             }
             else if(L2>R1)
             {
                 //partion x moving to right
                 low=partX+1;
             }
             else
             {
                 high=partX-1;
             }
        }
            
       
        return 266278.1881;
    }
}