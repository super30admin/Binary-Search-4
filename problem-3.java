//TC:o(logn)(where n os the length of smaller array)
//sc:o(1)

class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {

    if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
       
        int t = (n1+n2+1)/2;
        int px = 0;
        int py = 0;
        int low = 0;
        int high = n1;
        int net = n1+n2;
        while(low<=high)
        {
           px = low+(high-low)/2 ;
           py = t-px;
           int l1 = (((px<=0)?(Integer.MIN_VALUE):nums1[px-1]));
           int r1 = ((px>=n1)?Integer.MAX_VALUE:nums1[px]);
           int l2 = (((py<=0)?(Integer.MIN_VALUE):nums2[py-1]));
           int r2 = ((py>=n2)?Integer.MAX_VALUE:nums2[py]);  
          // System.out.println("l1 is "+l1);
           //System.out.println("l2 is "+l2);
           //System.out.println("r1 is "+r1);
           //System.out.println("r2 is "+r2); 
            
            if(l1<=r2 && l2<=r1)
            {
               if(net%2==0) 
                 return (Math.max(l1,l2)+Math.min(r1,r2))/2.0; 
               else
                 return (Math.max(l1,l2)); 
            }
            else if(l1>r2)
                high=(px-1);
            else if(l2>r1)
                low=(px+1);  
        }
      return 0.0;  
        
    }
}