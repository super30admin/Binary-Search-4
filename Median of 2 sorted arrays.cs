/*
  Time complexity: O(log(min(n1,n2))
  Space complexity: O(1)

*/

public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.Length;
        int n2 = nums2.Length;

        if(n1>n2)
        {
            return FindMedianSortedArrays(nums2,nums1);
        }

        int low = 0;
        int high = n1;

        while(low<=high)
        {
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;

            double X1 = partX==0 ? int.MinValue : nums1[partX-1];
            double Y1 = partX==n1 ? int.MaxValue : nums1[partX];

            double X2 = partY==0 ? int.MinValue : nums2[partY-1];
            double Y2 = partY==n2 ? int.MaxValue : nums2[partY];

            if(X1<=Y2 && X2<=Y1)
            {
                //odd
                if((n1+n2)%2==1)
                {
                    return Math.Min(Y1,Y2);
                }
                else
                {
                    //even
                    return (Math.Max(X1,X2) + Math.Min(Y1,Y2))/2;
                }
            }
            else
            {
                if(X1>Y2)
                {
                    high = partX-1;
                }
                else
                {
                    low = partX+1;
                }
            }
        }
        return 1.0;
    }
}
