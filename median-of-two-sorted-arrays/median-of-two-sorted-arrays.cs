public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null)
        {
            return 0;
        }
        int n1 = nums1.Length;
        int n2 = nums2.Length;
        
        if(n1>n2)
        {
            return FindMedianSortedArrays(nums2,nums1);
        }
        int low =0;
        int high =n1;
        while(low<=high)
        {
            int partx = low + (high-low)/2;
            int party = (n1+n2)/2 - partx;
            double l1 = partx-1 <0 ? int.MinValue : nums1[partx-1];
            double l2 = party-1 <0 ? int.MinValue : nums2[party-1];
            double r1 = partx ==n1? int.MaxValue : nums1[partx];
            double r2 = party ==n2? int.MaxValue : nums2[party];
            
            if(l1<=r2 && l2<=r1)
            { 
                if((n1+n2)%2==0)
                {
                    return (Math.Max(l1,l2) + Math.Min(r1,r2))/2;
                }
                else
                {
                    return Math.Min(r1,r2);
                }
            }
            else if (l1>r2)
            {
                high = partx-1;
            }
            else
            {
                low = partx+1;
            }
        }
        return 0;
        
    }
}
