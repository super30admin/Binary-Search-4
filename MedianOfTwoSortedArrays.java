class MedianOfTwoSortedArrays{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null)
        {
            return 0.0;
        }
        int n1=nums1.length;
        int n2 = nums2.length;
        if(n1>n2)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high = n1;
        while(low<=high)
        {
            int partX = low+(high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int L1 = partX ==0 ? Integer.MIN_VALUE : nums1[partX-1];
            int L2 = partY ==0 ? Integer.MIN_VALUE : nums2[partY-1];
            int R1 = partX ==n1 ? Integer.MAX_VALUE : nums1[partX];
            int R2 = partY ==n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <=R2 && L2<=R1)
            {
                //thi is the correct partition so we find median
                if((n1+n2)%2 ==0)
                {
                    return (Math.min(R1,R2) + Math.max(L1,L2))/2.0;
                }
                else{
                        return Math.min(R1,R2); 
                }
            }
            else if(L1 > R2)
            {
                    high = partX-1;
            }
            else
            {
                low = partX + 1;
            }
        }
 return 0.0;
    }
   
}

//tc: O(log(min(n1, n2)))
//sc: O(1)